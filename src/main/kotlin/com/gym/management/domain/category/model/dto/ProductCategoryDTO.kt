package com.gym.management.domain.category.model.dto

import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.request.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.request.AUpdateProductCategoryRequest
import java.time.LocalDateTime

data class ProductCategoryDTO(
    val productCategoryCode: String,
    val branchId: Int,
    val productCategoryName: String,
    val productCategoryCreatedAt: LocalDateTime = LocalDateTime.now(),
    val productCategoryUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val productCategoryDeleted: Char = 'N',
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

    constructor(aCreateProductCategoryRequest: ACreateProductCategoryRequest) : this(
        productCategoryCode = aCreateProductCategoryRequest.productCategoryCode,
        branchId = aCreateProductCategoryRequest.branchId,
        productCategoryName = aCreateProductCategoryRequest.productCategoryName,
        productCategoryCreatedAt = LocalDateTime.now(),
        productCategoryUpdatedAt = LocalDateTime.now(),
        productCategoryDeleted = 'N',
        userId = aCreateProductCategoryRequest.userId,
    )

    constructor(aUpdateProductCategoryRequest: AUpdateProductCategoryRequest) : this(
        productCategoryCode = aUpdateProductCategoryRequest.productCategoryCode,
        branchId = aUpdateProductCategoryRequest.branchId,
        productCategoryName = aUpdateProductCategoryRequest.productCategoryName,
        productCategoryCreatedAt = LocalDateTime.now(),
        productCategoryUpdatedAt = LocalDateTime.now(),
        productCategoryDeleted = aUpdateProductCategoryRequest.productCategoryDeleted,
        userId = aUpdateProductCategoryRequest.userId,
    )
}
