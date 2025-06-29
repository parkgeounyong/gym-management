package com.gym.management.domain.product.service

import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.CreateProductRequest
import com.gym.management.domain.product.model.entity.Product
import org.springframework.stereotype.Service

@Service
class DProductService(
    private val productRepository: ProductRepository
) {
    fun createProduct(createProductRequest: CreateProductRequest): ProductDTO {
        val productDTO = ProductDTO(createProductRequest)
        val result = productRepository.save(Product(productDTO))
        return ProductDTO(result)
    }
}