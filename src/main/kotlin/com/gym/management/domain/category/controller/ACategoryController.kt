package com.gym.management.domain.category.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.category.model.dto.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.dto.AUpdateProductCategoryRequest
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.service.ACategoryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

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
}