package com.gym.management.domain.product.model.dto

import com.gym.management.domain.product.model.entity.Product
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDTO(
    val productCode: String,
    val branchId: Int,
    val productCategoryCode: String,
    val productName: String,
    val productPrice: BigDecimal,
    val productCreatedAt: LocalDateTime = LocalDateTime.now(),
    val productUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val productDeleted: Char = 'N',
    val userId: String
) {
    constructor(product: Product) : this(
        productCode = product.productCode,
        branchId = product.branchId,
        productCategoryCode = product.procaCode,
        productName = product.productName,
        productPrice = product.productPrice,
        productCreatedAt = product.productCreatedAt,
        productUpdatedAt = product.productUpdatedAt,
        productDeleted = product.productDeleted,
        userId = product.userId
    )
}
