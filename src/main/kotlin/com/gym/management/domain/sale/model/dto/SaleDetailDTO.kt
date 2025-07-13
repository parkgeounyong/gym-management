package com.gym.management.domain.sale.model.dto

import java.math.BigDecimal

data class SaleDetailDTO(
    val saleId: Int,
    val branchId: Int,
    val saldeOrderSeq: Int,
    val procaCode: String,
    val productCode: String,
    val saldeProductPrice: BigDecimal,
    val saldeCount: Int,
    val saldeTotalAmount: BigDecimal,
)
