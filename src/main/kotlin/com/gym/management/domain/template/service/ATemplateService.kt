package com.gym.management.domain.template.service

import com.gym.management.config.exception.custom.template.TemplateNotFoundException
import com.gym.management.domain.template.model.TemplateDTOMapper.toTemplateDto
import com.gym.management.domain.template.model.TemplateMapper.toDto
import com.gym.management.domain.template.model.TemplateMapper.toEntity
import com.gym.management.domain.template.model.TemplateMapper.update
import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.model.entity.id.TemplateId
import com.gym.management.domain.template.model.request.ATemplateCreateRequest
import com.gym.management.domain.template.model.request.ATemplateUpdateRequest
import com.gym.management.domain.template.repository.TemplateRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ATemplateService(
    private val templateRepository: TemplateRepository,
) {
    fun createTemplates(aTemplateCreateRequest: ATemplateCreateRequest): TemplateDTO {
        return templateRepository.save(aTemplateCreateRequest.toTemplateDto().toEntity())
            .toDto()
    }

    @Transactional
    fun updateTemplates(aTemplateUpdateRequest: ATemplateUpdateRequest): TemplateDTO {
        return templateRepository.findById(
            TemplateId(
                aTemplateUpdateRequest.branchId,
                aTemplateUpdateRequest.templateCode
            )
        )
            .orElseThrow { TemplateNotFoundException() }
            .update(aTemplateUpdateRequest.toTemplateDto())
            .toDto()
    }

    fun findBy(branchId: Int, startAt: LocalDateTime, endAt: LocalDateTime): List<TemplateDTO> {
        return templateRepository.findByBranchIdAndTemplateEndAtGreaterThanEqualAndTemplateStartAtLessThanEqual(
            branchId,
            startAt,
            endAt
        ).map { it.toDto() }
    }

    fun findBy(branchId: Int, templateCode: String): TemplateDTO {
        return templateRepository.findById(TemplateId(branchId, templateCode))
            .orElseThrow { TemplateNotFoundException() }.toDto()
    }
}