package com.gym.management.domain.product.service

import com.gym.management.common.model.PageResponse
import com.gym.management.config.exception.custom.product.ProductNotFoundException
import com.gym.management.config.exception.custom.product.ProductTemplateNotFoundException
import com.gym.management.domain.product.model.ProductDTOMapper.toProductDto
import com.gym.management.domain.product.model.ProductMapper.toDto
import com.gym.management.domain.product.model.ProductMapper.toEntity
import com.gym.management.domain.product.model.ProductMapper.update
import com.gym.management.domain.product.model.ProductTemplateDTOMapper.toProductTemplateDto
import com.gym.management.domain.product.model.ProductTemplateMapper.toDto
import com.gym.management.domain.product.model.ProductTemplateMapper.toEntity
import com.gym.management.domain.product.model.ProductTemplateMapper.update
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.id.ProductId
import com.gym.management.domain.product.model.entity.id.ProductTemplateId
import com.gym.management.domain.product.model.request.CreateProductRequest
import com.gym.management.domain.product.model.request.CreateProductTemplateRequest
import com.gym.management.domain.product.model.request.UpdateProductRequest
import com.gym.management.domain.product.model.request.UpdateProductTemplateRequest
import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.repository.ProductTemplateRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AProductService(
    private val productTemplateRepository: ProductTemplateRepository,
    private val productRepository: ProductRepository,
) {
    fun createProductTemplates(createProductTemplateRequest: CreateProductTemplateRequest): ProductTemplateDTO {
        productRepository.findById(ProductId(createProductTemplateRequest.branchId, createProductTemplateRequest.productCode))
            .orElseThrow { ProductNotFoundException() }
        return productTemplateRepository.save(createProductTemplateRequest.toProductTemplateDto().toEntity())
            .toDto()
    }

    @Transactional
    fun updateProductTemplates(updateProductTemplateRequest: UpdateProductTemplateRequest): ProductTemplateDTO {
        return productTemplateRepository.findById(
            ProductTemplateId(
                updateProductTemplateRequest.branchId,
                updateProductTemplateRequest.templateCode,
                updateProductTemplateRequest.productCode
            )
        ).orElseThrow { ProductTemplateNotFoundException() }
            .update(updateProductTemplateRequest.toProductTemplateDto())
            .toDto()
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
        return productTemplateRepository.findById(ProductTemplateId(branchId, templateCode, productCode))
            .orElseThrow { ProductTemplateNotFoundException() }.toDto()
    }

    fun createProduct(createProductRequest: CreateProductRequest): ProductDTO {
        return productRepository.save(createProductRequest.toProductDto().toEntity()).toDto()
    }

    @Transactional
    fun updateProduct(updateProductRequest: UpdateProductRequest): ProductDTO {
        return productRepository.findById(ProductId(updateProductRequest.branchId, updateProductRequest.productCode))
            .orElseThrow { ProductNotFoundException() }
            .update(updateProductRequest.toProductDto())
            .toDto()
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
        return productRepository.findById(ProductId(branchId, productCode))
            .orElseThrow { ProductNotFoundException() }
            .toDto()
    }
}