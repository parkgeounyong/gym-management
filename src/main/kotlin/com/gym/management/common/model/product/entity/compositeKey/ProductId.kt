package com.gym.management.common.model.product.entity.compositeKey

import java.io.Serializable


data class ProductId(
    val productCode: String = "",
    val branchId: Int = 0
) : Serializable