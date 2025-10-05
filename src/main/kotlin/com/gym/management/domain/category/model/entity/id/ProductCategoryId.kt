package com.gym.management.domain.category.model.entity.id

import java.io.Serializable


data class ProductCategoryId(
    var branchId: Int? = null,

    var procaCode: String? = null

) : Serializable