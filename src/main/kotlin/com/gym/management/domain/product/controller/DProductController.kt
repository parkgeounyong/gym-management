package com.gym.management.domain.product.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.service.DProductService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Product")
class DProductController(
    private val dProductService: DProductService,
) {
    @PostMapping("/device/products")
    fun createProduct(
        @RequestBody productDTO: ProductDTO
    ): ApiResponse<ProductDTO> {
        return ApiResponse(
            data = dProductService.createProduct(productDTO)
        )
    }

    @PutMapping("/device/products")
    fun upsertProduct(
        @RequestBody productList: List<ProductDTO>
    ): ApiResponse<Boolean> {
        return ApiResponse(
            data = dProductService.upsertProduct(productList)
        )
    }

    @GetMapping("/device/products")
    fun findBy(
        @RequestParam("branchId") branchId: Int,
    ): ApiResponse<List<ProductDTO>> {
        return ApiResponse(
            data = dProductService.findBy(branchId)
        )
    }
}