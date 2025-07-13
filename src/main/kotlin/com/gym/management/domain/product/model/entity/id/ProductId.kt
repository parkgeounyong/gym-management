package com.gym.management.domain.product.model.entity.id

import java.io.Serializable


data class ProductId(
    var branchId: Int? = null,
    var productCode: String? = null
) : Serializable