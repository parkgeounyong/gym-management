package com.gym.management.domain.template.service

import com.gym.management.domain.template.model.entity.Template
import com.gym.management.domain.template.repository.TemplateRepository
import org.springframework.stereotype.Service

@Service
class DTemplateService(
    private val templateRepository: TemplateRepository,
) {
    fun selectAll(): MutableList<Template> = templateRepository.findAll()
}