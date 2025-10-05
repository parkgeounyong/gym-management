package com.gym.management.domain.sale.model

import com.gym.management.domain.sale.model.dto.SaleDTO
import com.gym.management.domain.sale.model.entity.Sale
import java.time.LocalDateTime

object SaleMapper {
    fun SaleDTO.toEntity(): Sale = Sale(
        saleId = this.saleId,
        branchId = this.branchId,
        saleBusinessDate = this.saleBusinessDate,
        saleOrderAt = this.saleOrderAt,
        saleTotalAmount = this.saleTotalAmount,
        createdAt = LocalDateTime.now(),
    )
}