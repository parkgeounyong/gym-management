package com.gym.management.domain.product.model.entity.id

import java.io.Serializable


data class ProductTemplateId(

    var branchId: Int? = null,

    var templateCode: String? = null,

    var productCode: String? = null
) : Serializable