package com.gym.management.domain.product.model

import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.ProductTemplate
import java.time.LocalDateTime

object ProductTemplateMapper {
    fun ProductTemplateDTO.toEntity(): ProductTemplate =
        ProductTemplate(
            branchId = this.branchId,
            templateCode = this.templateCode,
            productCode = this.productCode,
            proteName = this.proteName,
            protePrice = this.protePrice,
            proteCreatedAt = LocalDateTime.now(),
            proteUpdatedAt = LocalDateTime.now(),
            proteDeleted = 'N'
        )

    fun ProductTemplate.update(productTemplateDTO: ProductTemplateDTO): ProductTemplate {
        proteName = productTemplateDTO.proteName
        protePrice = productTemplateDTO.protePrice
        proteUpdatedAt = LocalDateTime.now()
        proteDeleted = productTemplateDTO.proteDeleted
        return this
    }

    fun ProductTemplate.toDto() = ProductTemplateDTO(
        branchId = this.branchId,
        templateCode = this.templateCode,
        productCode = this.productCode,
        proteName = this.proteName,
        protePrice = this.protePrice,
        proteCreatedAt = this.proteCreatedAt,
        proteUpdatedAt = this.proteUpdatedAt,
        proteDeleted = this.proteDeleted
    )
}