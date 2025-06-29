package com.gym.management.domain.product.controller

import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.CreateProductRequest
import com.gym.management.domain.product.service.DProductService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Product")
class DProductController(
    private val dProductService: DProductService,
) {
    @PostMapping("/device/product/products")
    fun createProduct(
        @RequestBody createProductRequest: CreateProductRequest
    ): ProductDTO {
        return dProductService.createProduct(createProductRequest)
    }
}