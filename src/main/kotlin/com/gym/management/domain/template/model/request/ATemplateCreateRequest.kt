package com.gym.management.domain.template.model.request

import java.time.LocalDateTime

data class ATemplateCreateRequest(
    val branchId: Int,
    val templateCode: String,
    val templateName: String,
    val templatePriority: Int,
    val templateStartAt: LocalDateTime = LocalDateTime.now(),
    val templateEndAt: LocalDateTime = LocalDateTime.now().withYear(100),
)