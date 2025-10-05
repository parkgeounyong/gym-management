package com.gym.management.domain.category.model

import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.request.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.request.AUpdateProductCategoryRequest
import java.time.LocalDateTime

object ProductCategoryDTOMapper {
    fun ProductCategory.toDto(): ProductCategoryDTO = ProductCategoryDTO(
        productCategoryCode = this.procaCode,
        branchId = this.branchId,
        productCategoryName = this.procaName,
        productCategoryCreatedAt = this.procaCreatedAt,
        productCategoryUpdatedAt = this.procaUpdatedAt,
        productCategoryDeleted = this.procaDeleted,
        userId = this.userId
    )


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