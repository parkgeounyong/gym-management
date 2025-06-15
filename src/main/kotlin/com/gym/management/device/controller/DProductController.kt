package com.gym.management.device.controller

import com.gym.management.common.model.product.dto.ProductDTO
import com.gym.management.device.model.product.DCreateProductRequest
import com.gym.management.device.service.DProductService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Product")
class DProductController(
    private val productService: DProductService,
) {
    @PostMapping("/device/product/products")
    fun createProduct(
        @RequestBody createProductRequest: DCreateProductRequest
    ): ProductDTO {
        return productService.createProduct(createProductRequest)
    }
}