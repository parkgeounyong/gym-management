package com.gym.management.domain.template.service

import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.model.entity.Template
import com.gym.management.domain.template.repository.TemplateRepository
import org.springframework.stereotype.Service

@Service
class ATemplateService(
    private val templateRepository: TemplateRepository,
) {
    fun createTemplates(templateDTO: TemplateDTO): TemplateDTO {
        val result = templateRepository.save(Template(templateDTO))
        return TemplateDTO(result)
    }
}