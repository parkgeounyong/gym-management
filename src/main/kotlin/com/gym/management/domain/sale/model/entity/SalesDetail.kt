package com.gym.management.domain.sale.model.entity

import com.gym.management.domain.sale.model.entity.id.SalesDetailId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.LocalDateTime

@IdClass(SalesDetailId::class)
@Entity
@Table(name = "gym_sales_detail")
class SalesDetail(
    @Id
    @NotNull
    @Column(name = "sale_id", nullable = false)
    val saleId: Int,

    @Id
    @NotNull
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @Id
    @NotNull
    @Column(name = "salde_order_seq", nullable = false)
    val saldeOrderSeq: Int,

    @Size(max = 10)
    @NotNull
    @Column(name = "proca_code", nullable = false, length = 10)
    val procaCode: String,

    @Size(max = 10)
    @NotNull
    @Column(name = "product_code", nullable = false, length = 10)
    val productCode: String,

    @NotNull
    @Column(name = "salde_product_price", nullable = false, precision = 10, scale = 2)
    val saldeProductPrice: BigDecimal,

    @NotNull
    @Column(name = "salde_count", nullable = false)
    val saldeCount: Int,

    @NotNull
    @Column(name = "salde_total_amount", nullable = false, precision = 10, scale = 2)
    val saldeTotalAmount: BigDecimal,

    @NotNull
    @Column(name = "salde_created_at", nullable = false)
    val saldeCreatedAt: LocalDateTime,
)