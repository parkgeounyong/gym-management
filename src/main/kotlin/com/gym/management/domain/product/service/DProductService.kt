package com.gym.management.domain.product.service

import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.entity.Product
import org.springframework.stereotype.Service

@Service
class DProductService(
    private val productRepository: ProductRepository
) {
    fun createProduct(productDTO: ProductDTO): ProductDTO {
        val result = productRepository.save(Product(productDTO))
        return ProductDTO(result)
    }

    fun findBy(branchId: Int): List<ProductDTO> {
        return productRepository.findByBranchId(branchId).map { ProductDTO(it) }
    }
}