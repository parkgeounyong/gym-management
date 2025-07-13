package com.gym.management.domain.sale.model.dto

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class SaleDTO(
    val saleId: Int,
    val branchId: Int,
    val saleBusinessDate: LocalDate,
    val saleOrderAt: LocalDateTime,
    val saleTotalAmount: BigDecimal,
)
