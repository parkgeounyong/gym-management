package com.gym.management.device.service

import com.gym.management.common.model.product.dto.ProductDTO
import com.gym.management.common.service.ProductService
import com.gym.management.device.model.product.DCreateProductRequest
import org.springframework.stereotype.Service

@Service
class DProductService(
    private val productService: ProductService,
) {
    fun createProduct(createProductRequest: DCreateProductRequest): ProductDTO {
        return productService.createProduct(ProductDTO(createProductRequest))
    }
}