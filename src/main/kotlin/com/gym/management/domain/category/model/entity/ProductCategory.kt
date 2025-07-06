package com.gym.management.domain.category.model.entity

import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@IdClass(ProductCategoryId::class)
@Entity
@Table(name = "gym_product_category")
class ProductCategory(
    @Id
    @Size(max = 10)
    @NotNull
    @Column(name = "proca_code", nullable = false, length = 10)
    val procaCode: String,

    @Id
    @NotNull
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @Size(max = 20)
    @NotNull
    @Column(name = "proca_name", nullable = false, length = 20)
    val procaName: String,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "proca_created_at", nullable = false)
    val procaCreatedAt: LocalDateTime,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "proca_updated_at", nullable = false)
    val procaUpdatedAt: LocalDateTime,

    @NotNull
    @ColumnDefault("'n'")
    @Column(name = "proca_deleted", nullable = false, length = Integer.MAX_VALUE)
    val procaDeleted: Char,

    @NotNull
    @Column(name = "user_id", nullable = false)
    val userId: String,
)