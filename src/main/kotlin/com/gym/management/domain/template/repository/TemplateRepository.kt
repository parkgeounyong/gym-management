package com.gym.management.domain.template.repository

import com.gym.management.domain.template.model.entity.Template
import com.gym.management.domain.template.model.entity.id.TemplateId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TemplateRepository : JpaRepository<Template, TemplateId> {
}