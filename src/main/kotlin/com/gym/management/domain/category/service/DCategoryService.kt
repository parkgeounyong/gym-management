package com.gym.management.domain.category.service

import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.repository.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class DCategoryService(
    private val productCategoryRepository: ProductCategoryRepository
) {
    fun createProductCategory(productCategoryDTO: ProductCategoryDTO): ProductCategoryDTO {
        val result = productCategoryRepository.save(ProductCategory(productCategoryDTO))
        return ProductCategoryDTO(result)
    }

    fun findProductCategoryBy(branchId: Int): List<ProductCategoryDTO> {
        return productCategoryRepository.findByBranchId(branchId).map { ProductCategoryDTO(it) }
    }
}