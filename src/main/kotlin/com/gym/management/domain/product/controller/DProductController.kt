package com.gym.management.domain.product.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.CreateProductRequest
import com.gym.management.domain.product.service.DProductService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Product")
class DProductController(
    private val dProductService: DProductService,
) {
    @PostMapping("/device/product/products")
    fun createProduct(
        @RequestBody createProductRequest: CreateProductRequest
    ): ApiResponse<ProductDTO> {
        return ApiResponse(
            data = dProductService.createProduct(createProductRequest)
        )
    }

    @GetMapping("/device/product/products")
    fun findBy(
        @RequestParam("branchId") branchId: Int,
    ): ApiResponse<List<ProductDTO>> {
        return ApiResponse(
            data = dProductService.findBy(branchId)
        )
    }
}