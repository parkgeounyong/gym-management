package com.gym.management.domain.product.service

import com.gym.management.domain.category.service.DCategoryService.Companion.logger
import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.entity.Product
import com.gym.management.domain.product.model.entity.id.ProductId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DProductService(
    private val productRepository: ProductRepository
) {
    fun createProduct(productDTO: ProductDTO): ProductDTO {
        val result = productRepository.save(Product(productDTO))
        return ProductDTO(result)
    }

    @Transactional
    fun updateProduct(productList: List<ProductDTO>): Boolean {
        val idList = productList.map { ProductId(it.branchId, it.productCode) }
        val entityMap =
            productRepository.findAllById(idList).associateBy { ProductId(it.branchId, it.productCode) }

        productList.forEach { productDTO ->
            entityMap[ProductId(productDTO.branchId, productDTO.productCode)]?.updateBy(
                productDTO
            ) ?: logger.warn { "Product not found when update. branchId=${productDTO.branchId}, code=${productDTO.productCode}" }
        }
        return true
    }

    fun findBy(branchId: Int): List<ProductDTO> {
        return productRepository.findByBranchId(branchId).map { ProductDTO(it) }
    }
}