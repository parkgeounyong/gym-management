package com.gym.management.domain.product.model.entity

import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.id.ProductTemplateId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.math.BigDecimal
import java.time.LocalDateTime

@IdClass(ProductTemplateId::class)
@Entity
@Table(name = "gym_product_template")
class ProductTemplate(
    @Id
    @NotNull
    @ColumnDefault("0")
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @Id
    @Size(max = 20)
    @NotNull
    @Column(name = "template_code", nullable = false, length = 20)
    val templateCode: String,

    @Id
    @Size(max = 10)
    @NotNull
    @Column(name = "product_code", nullable = false, length = 10)
    val productCode: String,

    @Size(max = 20)
    @NotNull
    @Column(name = "prote_name", nullable = false, length = 20)
    var proteName: String,

    @NotNull
    @Column(name = "prote_price", nullable = false)
    var protePrice: BigDecimal,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "prote_created_at", nullable = false)
    val proteCreatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "prote_updated_at", nullable = false)
    var proteUpdatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("'N'")
    @Column(name = "prote_deleted", nullable = false, length = Integer.MAX_VALUE)
    var proteDeleted: Char = 'N',
) {
    constructor(
        productTemplateDTO: ProductTemplateDTO
    ) : this(
        branchId = productTemplateDTO.branchId,
        templateCode = productTemplateDTO.templateCode,
        productCode = productTemplateDTO.productCode,
        proteName = productTemplateDTO.proteName,
        protePrice = productTemplateDTO.protePrice,
        proteCreatedAt = LocalDateTime.now(),
        proteUpdatedAt = LocalDateTime.now(),
        proteDeleted = 'N'
    )

    fun updateBy(productTemplateDTO: ProductTemplateDTO): ProductTemplate {
        proteName = productTemplateDTO.proteName
        protePrice = productTemplateDTO.protePrice
        proteUpdatedAt = LocalDateTime.now()
        proteDeleted = productTemplateDTO.proteDeleted
        return this
    }
}