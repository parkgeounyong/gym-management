package com.gym.management.domain.product.repository

import com.gym.management.domain.product.model.dto.ProductTemplateDTO

interface ProductTemplateRepositoryCustom {
    fun countProductTemplate(branchId: Int? = null, templateCode: String? = null): Int
    fun fetchProductTemplate(
        branchId: Int? = null,
        templateCode: String? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<ProductTemplateDTO>
}