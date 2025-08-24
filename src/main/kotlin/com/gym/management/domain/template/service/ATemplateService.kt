package com.gym.management.domain.template.service

import com.gym.management.config.exception.custom.template.TemplateNotFoundException
import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.model.entity.Template
import com.gym.management.domain.template.model.entity.id.TemplateId
import com.gym.management.domain.template.repository.TemplateRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ATemplateService(
    private val templateRepository: TemplateRepository,
) {
    fun createTemplates(templateDTO: TemplateDTO): TemplateDTO {
        val result = templateRepository.save(Template(templateDTO))
        return TemplateDTO(result)
    }

    @Transactional
    fun updateTemplates(templateDTO: TemplateDTO): TemplateDTO {
        val result = templateRepository.findById(TemplateId(templateDTO.branchId, templateDTO.templateCode))
            .orElseThrow { TemplateNotFoundException() }
            .updateBy(templateDTO)
        return TemplateDTO(result)
    }

    fun findBy(branchId: Int, startAt: LocalDateTime, endAt: LocalDateTime): List<TemplateDTO> {
        return templateRepository.findByBranchIdAndTemplateEndAtGreaterThanEqualAndTemplateStartAtLessThanEqual(
            branchId,
            startAt,
            endAt
        ).map { TemplateDTO(it) }
    }

    fun findBy(branchId: Int, templateCode: String): TemplateDTO {
        return TemplateDTO(
            templateRepository.findById(TemplateId(branchId, templateCode)).orElseThrow { TemplateNotFoundException() })
    }
}