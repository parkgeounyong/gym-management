package com.gym.management.domain.category.service

import com.gym.management.common.model.PageResponse
import com.gym.management.config.exception.custom.category.ProductCategoryNotFoundException
import com.gym.management.domain.category.model.request.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.request.AUpdateProductCategoryRequest
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import com.gym.management.domain.category.repository.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class ACategoryService(
    private val productCategoryRepository: ProductCategoryRepository
) {
    fun createProductCategory(aCreateProductCategoryRequest: ACreateProductCategoryRequest): ProductCategoryDTO {
        val productCategoryDTO = ProductCategoryDTO(aCreateProductCategoryRequest)
        val result = productCategoryRepository.save(ProductCategory(productCategoryDTO))
        return ProductCategoryDTO(result)
    }

    fun updateProductCategory(aUpdateProductCategoryRequest: AUpdateProductCategoryRequest): ProductCategoryDTO {
        val productCategoryDTO = ProductCategoryDTO(aUpdateProductCategoryRequest)
        val result =  productCategoryRepository.findById(ProductCategoryId(productCategoryDTO.productCategoryCode, productCategoryDTO.branchId))
            .orElseThrow { ProductCategoryNotFoundException() }
            .updateBy(productCategoryDTO)
        return ProductCategoryDTO(result)
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
        return ProductCategoryDTO(productCategoryRepository.findById(ProductCategoryId(procaCode, branchId)).orElseThrow { ProductCategoryNotFoundException() })
    }
}