package com.gym.management.domain.product.model.dto

import com.gym.management.domain.product.model.entity.Product
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDTO(
    val productCode: String,
    val branchId: Int,
    val procaCode: String,
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
        procaCode = product.procaCode,
        productName = product.productName,
        productPrice = product.productPrice,
        productCreatedAt = product.productCreatedAt,
        productUpdatedAt = product.productUpdatedAt,
        productDeleted = product.productDeleted,
        userId = product.userId
    )

    constructor(createProductRequest: CreateProductRequest) : this(
        productCode = createProductRequest.productCode,
        branchId = createProductRequest.branchId,
        procaCode = createProductRequest.categoryCode,
        productName = createProductRequest.productName,
        productPrice = createProductRequest.productPrice,
        productCreatedAt = createProductRequest.productCreatedAt,
        productUpdatedAt = createProductRequest.productUpdatedAt,
        productDeleted = createProductRequest.productDeleted,
        userId = createProductRequest.userId
    )
}
