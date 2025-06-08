package com.gym.management.common.model.product.entity

import com.gym.management.common.model.branch.entity.Branch
import com.gym.management.common.model.product.entity.compositeKey.ProductId
import com.gym.management.common.model.user.entity.User
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@IdClass(ProductId::class)
@Entity
@Table(name = "product")
class Product(
    @Id
    @Size(max = 10)
    @NotNull
    @Column(name = "product_code", nullable = false, length = 10)
    val productCode: String,

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val branch: Branch,

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
    @Column(name = "is_deleted", nullable = false, length = Integer.MAX_VALUE)
    val isDeleted: Char,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
)