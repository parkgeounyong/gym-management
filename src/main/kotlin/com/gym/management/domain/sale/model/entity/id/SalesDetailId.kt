package com.gym.management.domain.sale.model.entity.id

import java.io.Serializable


data class SalesDetailId(

    var saleId: Int? = null,

    var branchId: Int? = null,

    var saldeOrderSeq: Int? = null
) : Serializable