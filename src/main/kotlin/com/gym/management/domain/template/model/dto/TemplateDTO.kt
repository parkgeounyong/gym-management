package com.gym.management.domain.template.model.dto

import com.gym.management.domain.template.model.entity.Template
import java.time.LocalDateTime

data class TemplateDTO(
    val branchId: Int,
    val templateCode: String,
    val templateName: String,
    val templatePriority: Int,
    val templateStartAt: LocalDateTime = LocalDateTime.now(),
    val templateEndAt: LocalDateTime = LocalDateTime.now().withYear(100),
    val templateCreatedAt: LocalDateTime = LocalDateTime.now(),
    val templateUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val templateDeleted: Char = 'N',
) {
    constructor(template: Template) : this(
        branchId = template.branchId,
        templateCode = template.templateCode,
        templateName = template.templateName,
        templatePriority = template.templatePriority,
        templateStartAt = template.templateStartAt,
        templateEndAt = template.templateEndAt,
        templateCreatedAt = template.templateCreatedAt,
        templateUpdatedAt = template.templateUpdatedAt,
        templateDeleted = template.templateDeleted
    )
}