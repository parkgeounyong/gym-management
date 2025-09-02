package com.gym.management.domain.category.model

import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.request.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.request.AUpdateProductCategoryRequest
import java.time.LocalDateTime

object ProductCategoryDTOMapper {
    fun ACreateProductCategoryRequest.toProductCategoryDto(): ProductCategoryDTO =
        ProductCategoryDTO(
            productCategoryCode = this.productCategoryCode,
            branchId = this.branchId,
            productCategoryName = this.productCategoryName,
            productCategoryCreatedAt = LocalDateTime.now(),
            productCategoryUpdatedAt = LocalDateTime.now(),
            productCategoryDeleted = 'N',
            userId = this.userId,
        )

    fun AUpdateProductCategoryRequest.toProductCategoryDto(): ProductCategoryDTO =
        ProductCategoryDTO(
            productCategoryCode = this.productCategoryCode,
            branchId = this.branchId,
            productCategoryName = this.productCategoryName,
            productCategoryCreatedAt = LocalDateTime.now(),
            productCategoryUpdatedAt = LocalDateTime.now(),
            productCategoryDeleted = this.productCategoryDeleted,
            userId = this.userId,
        )
}