package com.gym.management.domain.category.service

import com.gym.management.common.model.PageResponse
import com.gym.management.config.exception.custom.category.ProductCategoryNotFoundException
import com.gym.management.domain.category.model.ProductCategoryDTOMapper.toProductCategoryDto
import com.gym.management.domain.category.model.ProductCategoryMapper.toDto
import com.gym.management.domain.category.model.ProductCategoryMapper.toEntity
import com.gym.management.domain.category.model.ProductCategoryMapper.update
import com.gym.management.domain.category.model.request.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.request.AUpdateProductCategoryRequest
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import com.gym.management.domain.category.repository.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class ACategoryService(
    private val productCategoryRepository: ProductCategoryRepository
) {
    fun createProductCategory(aCreateProductCategoryRequest: ACreateProductCategoryRequest): ProductCategoryDTO {
        return productCategoryRepository.save(aCreateProductCategoryRequest.toProductCategoryDto().toEntity())
            .toDto()
    }

    fun updateProductCategory(aUpdateProductCategoryRequest: AUpdateProductCategoryRequest): ProductCategoryDTO {
        val productCategoryDTO = aUpdateProductCategoryRequest.toProductCategoryDto()
        return productCategoryRepository.findById(
            ProductCategoryId(
                productCategoryDTO.productCategoryCode,
                productCategoryDTO.branchId
            )
        )
            .orElseThrow { ProductCategoryNotFoundException() }
            .update(productCategoryDTO)
            .toDto()
    }

    fun fetchProductCategory(
        branchId: Int? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): PageResponse<ProductCategoryDTO> {
        val count = productCategoryRepository.countProductCategory(branchId)
        val items = productCategoryRepository.fetchProductCategory(branchId, page, size, sortBy, direction)
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

    fun findBy(procaCode: String, branchId: Int): ProductCategoryDTO {
        return productCategoryRepository.findById(ProductCategoryId(procaCode, branchId))
            .orElseThrow { ProductCategoryNotFoundException() }.toDto()
    }
}