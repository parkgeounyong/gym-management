package com.gym.management.device.model.product

import java.math.BigDecimal

data class DCreateProductRequest(
    val productCode: String,
    val branchId: Int,
    val productName: String,
    val productPrice: BigDecimal,
    val userId: String
)