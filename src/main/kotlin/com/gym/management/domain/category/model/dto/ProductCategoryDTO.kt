package com.gym.management.domain.category.model.dto

import java.time.LocalDateTime

data class ProductCategoryDTO(
    val productCategoryCode: String,
    val branchId: Int,
    val productCategoryName: String,
    val productCategoryCreatedAt: LocalDateTime = LocalDateTime.now(),
    val productCategoryUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val productCategoryDeleted: Char = 'N',
    val userId: String,
)