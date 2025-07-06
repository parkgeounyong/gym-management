package com.gym.management.domain.category.model.dto

import com.gym.management.domain.category.model.entity.ProductCategory
import java.time.LocalDateTime

data class ProductCategoryDTO(
    val productCategoryCode: String,
    val branchId: Int,
    val productCategoryName: String,
    val productCategoryCreatedAt: LocalDateTime = LocalDateTime.now(),
    val productCategoryUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val productCategoryDeleted: Char,
    val userId: String,
) {
    constructor(productCategory: ProductCategory) : this(
        productCategoryCode = productCategory.procaCode,
        branchId = productCategory.branchId,
        productCategoryName = productCategory.procaName,
        productCategoryCreatedAt = productCategory.procaCreatedAt,
        productCategoryUpdatedAt = productCategory.procaUpdatedAt,
        productCategoryDeleted = productCategory.procaDeleted,
        userId = productCategory.userId
    )
}
