package com.gym.management.domain.product.model

import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.request.CreateProductRequest
import com.gym.management.domain.product.model.request.UpdateProductRequest
import java.time.LocalDateTime

object ProductDTOMapper {
    fun CreateProductRequest.toProductDto(): ProductDTO =
        ProductDTO(
            productCode = this.productCode,
            branchId = this.branchId,
            productCategoryCode = this.productCategoryCode,
            productName = this.productName,
            productPrice = this.productPrice,
            productCreatedAt = LocalDateTime.now(),
            productUpdatedAt = LocalDateTime.now(),
            productDeleted = 'N',
            userId = this.userId,
        )

    fun UpdateProductRequest.toProductDto(): ProductDTO =
        ProductDTO(
            productCode = this.productCode,
            branchId = this.branchId,
            productCategoryCode = this.productCategoryCode,
            productName = this.productName,
            productPrice = this.productPrice,
            productCreatedAt = LocalDateTime.now(),
            productUpdatedAt = LocalDateTime.now(),
            productDeleted = this.productDeleted,
            userId = this.userId,
        )
}