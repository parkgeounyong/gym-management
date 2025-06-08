package com.gym.management.common.model.product.data

import com.gym.management.common.model.branch.entity.Branch
import com.gym.management.common.model.user.entity.User
import java.time.LocalDateTime

data class ProductDTO(
    val productCode: String,
    val branch: Branch,
    val productName: String,
    val productCreatedAt: LocalDateTime,
    val productUpdatedAt: LocalDateTime,
    val isDeleted: Char,
    val user: User
)
