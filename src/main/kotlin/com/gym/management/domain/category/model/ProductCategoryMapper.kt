package com.gym.management.domain.category.model

import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import java.time.LocalDateTime

object ProductCategoryMapper {
    fun ProductCategoryDTO.toEntity(): ProductCategory =
        ProductCategory(
            procaCode = this.productCategoryCode,
            branchId = this.branchId,
            procaName = this.productCategoryName,
            procaCreatedAt = LocalDateTime.now(),
            procaUpdatedAt = LocalDateTime.now(),
            procaDeleted = this.productCategoryDeleted,
            userId = this.userId
        )

    fun ProductCategory.toDto(): ProductCategoryDTO = ProductCategoryDTO(
        productCategoryCode = this.procaCode,
        branchId = this.branchId,
        productCategoryName = this.procaName,
        productCategoryCreatedAt = this.procaCreatedAt,
        productCategoryUpdatedAt = this.procaUpdatedAt,
        productCategoryDeleted = this.procaDeleted,
        userId = this.userId
    )

    fun ProductCategory.update(productCategoryDTO: ProductCategoryDTO): ProductCategory{
        procaName = productCategoryDTO.productCategoryName
        procaUpdatedAt = LocalDateTime.now()
        procaDeleted = productCategoryDTO.productCategoryDeleted
        userId = productCategoryDTO.userId
        return this
    }
}