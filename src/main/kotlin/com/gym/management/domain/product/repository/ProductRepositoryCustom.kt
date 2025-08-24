package com.gym.management.domain.product.repository

import com.gym.management.domain.product.model.dto.ProductDTO
import java.time.LocalDateTime

interface ProductRepositoryCustom {
    fun findBy(branchId: Int, localDateTime: LocalDateTime): List<ProductDTO>
    fun countProduct(branchId: Int? = null): Int
    fun fetchProduct(
        branchId: Int? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<ProductDTO>
}