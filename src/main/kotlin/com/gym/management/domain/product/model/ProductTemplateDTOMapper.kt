package com.gym.management.domain.product.model

import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.request.CreateProductTemplateRequest
import com.gym.management.domain.product.model.request.UpdateProductTemplateRequest
import java.time.LocalDateTime

object ProductTemplateDTOMapper {
    fun CreateProductTemplateRequest.toProductTemplateDto(): ProductTemplateDTO =
        ProductTemplateDTO(
            branchId = this.branchId,
            templateCode = this.templateCode,
            productCode = this.productCode,
            proteName = this.proteName,
            protePrice = this.protePrice,
            proteCreatedAt = LocalDateTime.now(),
            proteUpdatedAt = LocalDateTime.now(),
            proteDeleted = 'N'
        )

    fun UpdateProductTemplateRequest.toProductTemplateDto(): ProductTemplateDTO =
        ProductTemplateDTO(
            branchId = this.branchId,
            templateCode = this.templateCode,
            productCode = this.productCode,
            proteName = this.proteName,
            protePrice = this.protePrice,
            proteCreatedAt = LocalDateTime.now(),
            proteUpdatedAt = LocalDateTime.now(),
            proteDeleted = this.proteDeleted
        )
}