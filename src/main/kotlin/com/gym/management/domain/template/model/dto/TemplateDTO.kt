package com.gym.management.domain.template.model.dto

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
)