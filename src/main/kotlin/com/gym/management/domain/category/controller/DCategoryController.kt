package com.gym.management.domain.category.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.service.DCategoryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Category")
class DCategoryController(
    private val dCategoryService: DCategoryService
) {
    @PostMapping("/device/categories")
    fun createProductCategory(
        @RequestBody productCategoryDTO: ProductCategoryDTO
    ): ApiResponse<ProductCategoryDTO> {
        return ApiResponse(
            data = dCategoryService.createProductCategory(productCategoryDTO)
        )
    }

    @PutMapping("/device/categories")
    fun upsertProductCategory(
        @RequestBody productCategoryList: List<ProductCategoryDTO>
    ): ApiResponse<Boolean> {
        return ApiResponse(
            data = dCategoryService.upsertProductCategory(productCategoryList)
        )
    }

    @GetMapping("/device/categories")
    fun findBy(
        @RequestParam("branchId") branchId: Int,
    ): ApiResponse<List<ProductCategoryDTO>> {
        return ApiResponse(
            data = dCategoryService.findProductCategoryBy(branchId)
        )
    }
}