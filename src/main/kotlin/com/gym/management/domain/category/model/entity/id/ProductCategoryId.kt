package com.gym.management.domain.category.model.entity.id

import java.io.Serializable


data class ProductCategoryId(

    var procaCode: String? = null,

    var branchId: Int? = null
) : Serializable