package com.gym.management.domain.product.service

import com.gym.management.config.exception.custom.product.ProductTemplateNotFoundException
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.ProductTemplate
import com.gym.management.domain.product.model.entity.id.ProductTemplateId
import com.gym.management.domain.product.repository.ProductTemplateRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AProductService(
    private val productTemplateRepository: ProductTemplateRepository,
) {
    fun createProductTemplates(productTemplateDTO: ProductTemplateDTO): ProductTemplateDTO {
        val result = productTemplateRepository.save(ProductTemplate(productTemplateDTO))
        return ProductTemplateDTO(result)
    }

    @Transactional
    fun updateProductTemplates(productTemplateDTO: ProductTemplateDTO): ProductTemplateDTO {
        val result = productTemplateRepository.findById(ProductTemplateId(productTemplateDTO.branchId, productTemplateDTO.templateCode, productTemplateDTO.productCode))
            .orElseThrow { ProductTemplateNotFoundException() }
            .updateBy(productTemplateDTO)
        return ProductTemplateDTO(result)
    }
}