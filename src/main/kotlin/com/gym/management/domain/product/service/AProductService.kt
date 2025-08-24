package com.gym.management.domain.product.service

import com.gym.management.common.model.PageResponse
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

    fun fetchProductTemplate(
        branchId: Int? = null,
        templateCode: String? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): PageResponse<ProductTemplateDTO> {
        val count = productTemplateRepository.countProductTemplate(branchId, templateCode)
        val items =
            productTemplateRepository.fetchProductTemplate(branchId, templateCode, page, size, sortBy, direction)
        return PageResponse(
            totalCount = count,
            totalPages = (count + size - 1) / size,
            page = page,
            size = size,
            sortBy = sortBy,
            direction = direction,
            items = items
        )
    }

    fun findBy(branchId: Int, templateCode: String, productCode: String): ProductTemplateDTO {
        return ProductTemplateDTO(
            productTemplateRepository.findById(ProductTemplateId(branchId, templateCode, productCode))
                .orElseThrow { ProductTemplateNotFoundException() })
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

    fun fetchProduct(
        branchId: Int? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): PageResponse<ProductDTO> {
        val count = productRepository.countProduct(branchId)
        val items = productRepository.fetchProduct(branchId, page, size, sortBy, direction)
        return PageResponse(
            totalCount = count,
            totalPages = (count + size - 1) / size,
            page = page,
            size = size,
            sortBy = sortBy,
            direction = direction,
            items = items
        )
    }

    fun findBy(branchId: Int, productCode: String): ProductDTO {
        return ProductDTO(productRepository.findById(ProductId(branchId, productCode))
            .orElseThrow { ProductNotFoundException() })
    }
}