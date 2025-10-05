package com.gym.management.domain.category.model.entity

import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@IdClass(ProductCategoryId::class)
@Entity
@Table(name = "gym_product_category")
class ProductCategory(
    @Id
    @NotNull
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @Id
    @Size(max = 10)
    @NotNull
    @Column(name = "proca_code", nullable = false, length = 10)
    val procaCode: String,

    @Size(max = 20)
    @NotNull
    @Column(name = "proca_name", nullable = false, length = 20)
    var procaName: String,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "proca_created_at", nullable = false)
    val procaCreatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "proca_updated_at", nullable = false)
    var procaUpdatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("'N'")
    @Column(name = "proca_deleted", nullable = false, length = Integer.MAX_VALUE)
    @Comment("삭제 여부, 'Y'는 삭제됨, 'N'은 사용 중")
    var procaDeleted: Char = 'N',

    @NotNull
    @Column(name = "user_id", nullable = false)
    var userId: String,
)