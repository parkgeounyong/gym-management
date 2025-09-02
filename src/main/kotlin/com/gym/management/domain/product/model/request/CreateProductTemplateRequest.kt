package com.gym.management.domain.product.model.request

import java.math.BigDecimal

data class CreateProductTemplateRequest(
    val branchId: Int,
    val templateCode: String,
    val productCode: String,
    val proteName: String,
    val protePrice: BigDecimal,
)