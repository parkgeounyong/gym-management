package com.gym.management.domain.category.model.dto

data class ACreateProductCategoryRequest(
    val productCategoryCode: String,
    val branchId: Int,
    val productCategoryName: String,
    val userId: String,
)