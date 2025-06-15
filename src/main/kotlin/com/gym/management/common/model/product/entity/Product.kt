package com.gym.management.common.model.product.entity

import com.gym.management.common.model.product.entity.id.ProductId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@IdClass(ProductId::class)
@Entity
@Table(name = "gym_product")
class Product(
    @Id
    @Size(max = 10)
    @NotNull
    @Column(name = "product_code", nullable = false, length = 10)
    val productCode: String,

    @Id
    @NotNull
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @Size(max = 20)
    @NotNull
    @Column(name = "product_name", nullable = false, length = 20)
    val productName: String,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "product_created_at", nullable = false)
    val productCreatedAt: LocalDateTime,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "product_updated_at", nullable = false)
    val productUpdatedAt: LocalDateTime,

    @NotNull
    @ColumnDefault("'n'")
    @Column(name = "product_deleted", nullable = false, length = Integer.MAX_VALUE)
    val productDeleted: Char,

    @NotNull
    @Column(name = "user_id", nullable = false)
    val userId: String
)