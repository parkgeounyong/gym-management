package com.gym.management.domain.product.model.entity

import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.entity.id.ProductId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.math.BigDecimal
import java.time.LocalDateTime

@IdClass(ProductId::class)
@Entity
@Table(name = "gym_product")
class Product(
    @Id
    @NotNull
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @Id
    @Size(max = 10)
    @NotNull
    @Column(name = "product_code", nullable = false, length = 10)
    val productCode: String,

    @Size(max = 10)
    @NotNull
    @Column(name = "proca_code", nullable = false, length = 10)
    val procaCode: String,

    @Size(max = 20)
    @NotNull
    @Column(name = "product_name", nullable = false, length = 20)
    val productName: String,

    @NotNull
    @Column(name = "product_price", nullable = false)
    val productPrice: BigDecimal,

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
) {
    constructor(productDTO: ProductDTO) : this(
        productCode = productDTO.productCode,
        branchId = productDTO.branchId,
        procaCode = productDTO.productCategoryCode,
        productName = productDTO.productName,
        productPrice = productDTO.productPrice,
        productCreatedAt = productDTO.productCreatedAt,
        productUpdatedAt = productDTO.productUpdatedAt,
        productDeleted = productDTO.productDeleted,
        userId = productDTO.userId
    )
}