package com.gym.management.common.model.product.dto

import com.gym.management.common.model.product.entity.Product
import com.gym.management.device.model.product.DCreateProductRequest
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDTO(
    val productCode: String,
    val branchId: Int,
    val productName: String,
    val productPrice: BigDecimal,
    val productCreatedAt: LocalDateTime,
    val productUpdatedAt: LocalDateTime,
    val productDeleted: Char,
    val userId: String
) {
    constructor(product: Product) : this(
        productCode = product.productCode,
        branchId = product.branchId,
        productName = product.productName,
        productPrice = product.productPrice,
        productCreatedAt = product.productCreatedAt,
        productUpdatedAt = product.productUpdatedAt,
        productDeleted = product.productDeleted,
        userId = product.userId
    )

    constructor(dCreateProductRequest: DCreateProductRequest) : this(
        productCode = dCreateProductRequest.productCode,
        branchId = dCreateProductRequest.branchId,
        productName = dCreateProductRequest.productName,
        productPrice = dCreateProductRequest.productPrice,
        productCreatedAt = LocalDateTime.now(),
        productUpdatedAt = LocalDateTime.now(),
        productDeleted = 'N',
        userId = dCreateProductRequest.userId
    )
}
