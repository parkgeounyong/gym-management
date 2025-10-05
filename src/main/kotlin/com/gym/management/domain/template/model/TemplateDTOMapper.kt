package com.gym.management.domain.template.model

import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.model.entity.Template
import com.gym.management.domain.template.model.request.ATemplateCreateRequest
import com.gym.management.domain.template.model.request.ATemplateUpdateRequest
import java.time.LocalDateTime

object TemplateDTOMapper {
    fun Template.toDto(): TemplateDTO =
        TemplateDTO(
            branchId = this.branchId,
            templateCode = this.templateCode,
            templateName = this.templateName,
            templatePriority = this.templatePriority,
            templateStartAt = this.templateStartAt,
            templateEndAt = this.templateEndAt,
            templateCreatedAt = this.templateCreatedAt,
            templateUpdatedAt = this.templateUpdatedAt,
            templateDeleted = this.templateDeleted
        )

    fun ATemplateCreateRequest.toTemplateDto(): TemplateDTO =
        TemplateDTO(
            branchId = this.branchId,
            templateCode = this.templateCode,
            templateName = this.templateName,
            templatePriority = this.templatePriority,
            templateStartAt = this.templateStartAt,
            templateEndAt = this.templateEndAt,
            templateCreatedAt = LocalDateTime.now(),
            templateUpdatedAt = LocalDateTime.now(),
            templateDeleted = 'N'
        )

    fun ATemplateUpdateRequest.toTemplateDto(): TemplateDTO =
        TemplateDTO(
            branchId = this.branchId,
            templateCode = this.templateCode,
            templateName = this.templateName,
            templatePriority = this.templatePriority,
            templateStartAt = this.templateStartAt,
            templateEndAt = this.templateEndAt,
            templateCreatedAt = LocalDateTime.now(),
            templateUpdatedAt = LocalDateTime.now(),
            templateDeleted = 'N'
        )
}