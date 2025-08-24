package com.gym.management.domain.product.repository

import com.gym.management.domain.product.model.entity.ProductTemplate
import com.gym.management.domain.product.model.entity.id.ProductTemplateId
import org.springframework.data.jpa.repository.JpaRepository

interface ProductTemplateRepository : JpaRepository<ProductTemplate, ProductTemplateId>, ProductTemplateRepositoryCustom {
}