package com.gym.management.common.service

import com.gym.management.common.model.product.dto.ProductDTO
import com.gym.management.common.model.product.entity.Product
import com.gym.management.common.repository.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun createProduct(productDTO: ProductDTO): ProductDTO {
        val result = productRepository.save(Product(productDTO))
        return ProductDTO(result)
    }
}