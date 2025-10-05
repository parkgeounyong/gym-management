package com.gym.management.domain.category.model.request

data class AUpdateProductCategoryRequest(
    val branchId: Int,
    val productCategoryCode: String,
    val productCategoryName: String,
    val productCategoryDeleted: Char = 'N',
    val userId: String,
)
