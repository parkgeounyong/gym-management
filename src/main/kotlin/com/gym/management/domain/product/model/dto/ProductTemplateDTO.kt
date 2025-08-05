package com.gym.management.domain.product.model.dto

import com.gym.management.domain.product.model.entity.ProductTemplate
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductTemplateDTO(
    val branchId: Int,
    val templateCode: String,
    val productCode: String,
    val proteName: String,
    val protePrice: BigDecimal,
    val proteCreatedAt: LocalDateTime = LocalDateTime.now(),
    val proteUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val proteDeleted: Char = 'N',
) {
    constructor(productTemplate: ProductTemplate) : this(
        branchId = productTemplate.branchId,
        templateCode = productTemplate.templateCode,
        productCode = productTemplate.productCode,
        proteName = productTemplate.proteName,
        protePrice = productTemplate.protePrice,
        proteCreatedAt = productTemplate.proteCreatedAt,
        proteUpdatedAt = productTemplate.proteUpdatedAt,
        proteDeleted = productTemplate.proteDeleted
    )
}