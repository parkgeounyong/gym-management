package com.gym.management.common.model.product.entity.id

import java.io.Serializable


data class ProductId(

    var productCode: String? = null,

    var branchId: Int? = null
) : Serializable