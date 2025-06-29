package com.gym.management.domain.product.model.entity.id

import java.io.Serializable


data class ProductId(

    var productCode: String? = null,

    var branchId: Int? = null
) : Serializable