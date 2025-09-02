package com.gym.management.domain.product.model.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductTemplateDTO(
    val branchId: Int,
    val templateCode: String,
    val productCode: String,
    val proteName: String,
    val protePrice: BigDecimal,
    val proteCreatedAt: LocalDateTime = LocalDateTime.now(),
    val proteUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val proteDeleted: Char = 'N',
)