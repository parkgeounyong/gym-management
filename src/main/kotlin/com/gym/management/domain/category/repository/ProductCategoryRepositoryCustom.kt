package com.gym.management.domain.category.repository

import com.gym.management.domain.category.model.dto.ProductCategoryDTO

interface ProductCategoryRepositoryCustom {
    fun countProductCategory(branchId: Int? = null): Int
    fun fetchProductCategory(
        branchId: Int? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<ProductCategoryDTO>
}