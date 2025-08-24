package com.gym.management.domain.product.service

import com.gym.management.config.exception.custom.product.ProductNotFoundException
import com.gym.management.config.exception.custom.product.ProductTemplateNotFoundException
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.Product
import com.gym.management.domain.product.model.entity.ProductTemplate
import com.gym.management.domain.product.model.entity.id.ProductId
import com.gym.management.domain.product.model.entity.id.ProductTemplateId
import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.repository.ProductTemplateRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AProductService(
    private val productTemplateRepository: ProductTemplateRepository,
    private val productRepository: ProductRepository,
) {
    fun createProductTemplates(productTemplateDTO: ProductTemplateDTO): ProductTemplateDTO {
        productRepository.findById(ProductId(productTemplateDTO.branchId, productTemplateDTO.productCode))
            .orElseThrow { ProductNotFoundException() }
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

    fun createProduct(productDTO: ProductDTO): ProductDTO {
        val result = productRepository.save(Product(productDTO))
        return ProductDTO(result)
    }

    @Transactional
    fun updateProduct(productDTO: ProductDTO): ProductDTO {
        val result = productRepository.findById(ProductId(productDTO.branchId, productDTO.productCode))
            .orElseThrow { ProductNotFoundException() }
            .updateBy(productDTO)
        return ProductDTO(result)
    }
}