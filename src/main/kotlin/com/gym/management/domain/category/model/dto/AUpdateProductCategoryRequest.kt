package com.gym.management.domain.category.model.dto

data class AUpdateProductCategoryRequest(
    val productCategoryCode: String,
    val branchId: Int,
    val productCategoryName: String,
    val productCategoryDeleted: Char = 'N',
    val userId: String,
)
