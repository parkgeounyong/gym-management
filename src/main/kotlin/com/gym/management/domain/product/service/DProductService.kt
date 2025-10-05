package com.gym.management.domain.product.service

import com.gym.management.domain.product.model.ProductDTOMapper.toProductDto
import com.gym.management.domain.product.model.ProductDTOMapper.toDto
import com.gym.management.domain.product.model.ProductMapper.toEntity
import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.request.CreateProductRequest
import com.gym.management.domain.product.model.request.UpdateProductRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class DProductService(
    private val productRepository: ProductRepository,
) {
    fun createProduct(createProductRequest: CreateProductRequest): ProductDTO {
        return productRepository.save(createProductRequest.toProductDto().toEntity())
            .toDto()
    }

    @Transactional
    fun upsertProduct(updateProductRequestList: List<UpdateProductRequest>): Boolean {
        productRepository.bulkUpsertProduct(updateProductRequestList.map { it.toProductDto().toEntity() })
        return true
    }

    fun findBy(branchId: Int, localDateTime: LocalDateTime): List<ProductDTO> {
        return productRepository.findBy(branchId, localDateTime)
    }
}