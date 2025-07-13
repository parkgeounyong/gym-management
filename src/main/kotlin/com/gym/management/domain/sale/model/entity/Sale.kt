package com.gym.management.domain.sale.model.entity

import com.gym.management.domain.sale.model.dto.SaleDTO
import com.gym.management.domain.sale.model.entity.id.SaleId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@IdClass(SaleId::class)
@Entity
@Table(name = "gym_sales")
class Sale(
    @Id
    @NotNull
    @Column(name = "sale_id", nullable = false)
    val saleId: Int,

    @Id
    @NotNull
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @NotNull
    @Column(name = "sale_business_date", nullable = false)
    val saleBusinessDate: LocalDate,

    @NotNull
    @Column(name = "sale_order_at", nullable = false)
    val saleOrderAt: LocalDateTime,

    @NotNull
    @Column(name = "sale_total_amount", nullable = false, precision = 10, scale = 2)
    val saleTotalAmount: BigDecimal,

    @NotNull
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime,
) {
    constructor(saleDTO: SaleDTO) : this(
        saleId = saleDTO.saleId,
        branchId = saleDTO.branchId,
        saleBusinessDate = saleDTO.saleBusinessDate,
        saleOrderAt = saleDTO.saleOrderAt,
        saleTotalAmount = saleDTO.saleTotalAmount,
        createdAt = LocalDateTime.now(),
    )
}