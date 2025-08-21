package com.gym.management.domain.category.service

import com.gym.management.domain.category.model.dto.ACreateProductCategoryRequest
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
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
}