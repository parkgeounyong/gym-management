package com.gym.management.domain.product.model.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CreateProductRequest(
    val productCode: String,
    val branchId: Int,
    val productName: String,
    val productPrice: BigDecimal,
    val productCreatedAt: LocalDateTime = LocalDateTime.now(),
    val productUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val productDeleted: Char = 'N',
    val userId: String
)