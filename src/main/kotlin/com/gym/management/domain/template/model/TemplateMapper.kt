package com.gym.management.domain.template.model

import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.model.entity.Template
import java.time.LocalDateTime

object TemplateMapper {
    fun TemplateDTO.toEntity(): Template = Template(
        branchId = this.branchId,
        templateCode = this.templateCode,
        templateName = this.templateName,
        templatePriority = this.templatePriority,
        templateStartAt = this.templateStartAt,
        templateEndAt = this.templateEndAt,
        templateCreatedAt = LocalDateTime.now(),
        templateUpdatedAt = LocalDateTime.now(),
        templateDeleted = 'N',
    )

    fun Template.update(templateDTO: TemplateDTO): Template {
        templateName = templateDTO.templateName
        templatePriority = templateDTO.templatePriority
        templateStartAt = templateDTO.templateStartAt
        templateEndAt = templateDTO.templateEndAt
        templateUpdatedAt = LocalDateTime.now()
        templateDeleted = templateDTO.templateDeleted
        return this
    }
}