package com.gym.management.domain.category.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.common.model.PageResponse
import com.gym.management.domain.category.model.request.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.request.AUpdateProductCategoryRequest
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.service.ACategoryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Category")
class ACategoryController(
    private val aCategoryService: ACategoryService,
) {
    @PostMapping("/admin/categories")
    fun createProductCategory(
        @RequestBody aCreateProductCategoryRequest: ACreateProductCategoryRequest
    ): ApiResponse<ProductCategoryDTO> {
        return ApiResponse(
            data = aCategoryService.createProductCategory(aCreateProductCategoryRequest)
        )
    }

    @PutMapping("/admin/categories")
    fun updateProductCategory(
        @RequestBody aUpdateProductCategoryRequest: AUpdateProductCategoryRequest
    ): ApiResponse<ProductCategoryDTO> {
        return ApiResponse(
            data = aCategoryService.updateProductCategory(aUpdateProductCategoryRequest)
        )
    }

    @GetMapping("/admin/categories")
    fun fetchCategory(
        @RequestParam branchId: Int? = null,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @RequestParam sortBy: String,
        @RequestParam direction: String
    ): ApiResponse<PageResponse<ProductCategoryDTO>> {
        return ApiResponse(data = aCategoryService.fetchProductCategory(branchId, page, size, sortBy, direction))
    }

    @GetMapping("/admin/categories/{branchId}/{procaCode}")
    fun findBy(
        @PathVariable branchId: Int,
        @PathVariable procaCode: String
    ): ApiResponse<ProductCategoryDTO> {
        return ApiResponse(data = aCategoryService.findBy(procaCode, branchId))
    }
}