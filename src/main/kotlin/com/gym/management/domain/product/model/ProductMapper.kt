package com.gym.management.domain.product.model

import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.entity.Product
import java.time.LocalDateTime

object ProductMapper {
    fun ProductDTO.toEntity(): Product =
        Product(
            productCode = this.productCode,
            branchId = this.branchId,
            procaCode = this.productCategoryCode,
            productName = this.productName,
            productPrice = this.productPrice,
            productCreatedAt = LocalDateTime.now(),
            productUpdatedAt = LocalDateTime.now(),
            productDeleted = 'N',
            userId = this.userId
        )

    fun Product.update(productDTO: ProductDTO): Product {
        procaCode = productDTO.productCategoryCode
        productName = productDTO.productName
        productPrice = productDTO.productPrice
        productUpdatedAt = LocalDateTime.now()
        productDeleted = productDTO.productDeleted
        userId = productDTO.userId
        return this
    }
}