package com.gym.management.domain.product.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.request.CreateProductRequest
import com.gym.management.domain.product.model.request.UpdateProductRequest
import com.gym.management.domain.product.service.DProductService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@Tag(name = "Product")
class DProductController(
    private val dProductService: DProductService,
) {
    @PostMapping("/device/products")
    fun createProduct(
        @RequestBody createProductRequest: CreateProductRequest
    ): ApiResponse<ProductDTO> {
        return ApiResponse(
            data = dProductService.createProduct(createProductRequest)
        )
    }

    @PutMapping("/device/products")
    fun upsertProduct(
        @RequestBody updateProductRequests: List<UpdateProductRequest>
    ): ApiResponse<Boolean> {
        return ApiResponse(
            data = dProductService.upsertProduct(updateProductRequests)
        )
    }

    @GetMapping("/device/products")
    fun findBy(
        @RequestParam("branchId") branchId: Int,
        @RequestParam("localDateTime") localDateTime: LocalDateTime = LocalDateTime.now(),
    ): ApiResponse<List<ProductDTO>> {
        return ApiResponse(
            data = dProductService.findBy(branchId, localDateTime)
        )
    }
}