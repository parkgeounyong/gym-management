package com.gym.management.domain.product.service

import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.ProductTemplate
import com.gym.management.domain.product.repository.ProductTemplateRepository
import org.springframework.stereotype.Service

@Service
class AProductService(
    private val productTemplateRepository: ProductTemplateRepository,
) {
    fun createProductTemplates(productTemplateDTO: ProductTemplateDTO): ProductTemplateDTO {
        val result = productTemplateRepository.save(ProductTemplate(productTemplateDTO))
        return ProductTemplateDTO(result)
    }
}