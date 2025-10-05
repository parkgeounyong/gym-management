package com.gym.management.domain.sale.model


import com.gym.management.domain.sale.model.dto.SaleDetailDTO
import com.gym.management.domain.sale.model.entity.SaleDetail
import java.time.LocalDateTime

object SaleDetailMapper {
    fun SaleDetailDTO.toEntity(): SaleDetail =
        SaleDetail(
            saleId = this.saleId,
            branchId = this.branchId,
            saldeOrderSeq = this.saldeOrderSeq,
            procaCode = this.procaCode,
            productCode = this.productCode,
            saldeProductPrice = this.saldeProductPrice,
            saldeCount = this.saldeCount,
            saldeTotalAmount = this.saldeTotalAmount,
            saldeCreatedAt = LocalDateTime.now()
        )
}