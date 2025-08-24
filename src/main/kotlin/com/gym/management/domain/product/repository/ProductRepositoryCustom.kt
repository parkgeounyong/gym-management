package com.gym.management.domain.product.repository

import com.gym.management.domain.product.model.dto.ProductDTO
import java.time.LocalDateTime

interface ProductRepositoryCustom {
    fun findBy(branchId: Int, localDateTime: LocalDateTime): List<ProductDTO>
}