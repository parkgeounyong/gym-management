package com.gym.management.domain.category.service

import com.gym.management.domain.category.model.dto.CreateProductCategoryRequest
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import org.springframework.stereotype.Service

@Service
class ACategoryService(
    private val categoryService: CategoryService
) {
    fun createProductCategory(createProductCategoryRequest: CreateProductCategoryRequest): ProductCategoryDTO =
        categoryService.createProductCategory(ProductCategoryDTO(createProductCategoryRequest))
}