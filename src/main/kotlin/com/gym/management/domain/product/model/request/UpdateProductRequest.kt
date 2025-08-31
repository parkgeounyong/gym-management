package com.gym.management.domain.product.model.request

import java.math.BigDecimal

data class UpdateProductRequest(
    val productCode: String,
    val branchId: Int,
    val productCategoryCode: String,
    val productName: String,
    val productPrice: BigDecimal,
    val productDeleted: Char = 'N',
    val userId: String
)