package com.gym.management.domain.template.repository

import com.gym.management.domain.template.model.entity.Template
import com.gym.management.domain.template.model.entity.id.TemplateId
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface TemplateRepository : JpaRepository<Template, TemplateId> {
    fun findByBranchIdAndTemplateEndAtGreaterThanEqualAndTemplateStartAtLessThanEqual(
        branch: Int,
        startAt: LocalDateTime,
        endAt: LocalDateTime
    ): List<Template>
}