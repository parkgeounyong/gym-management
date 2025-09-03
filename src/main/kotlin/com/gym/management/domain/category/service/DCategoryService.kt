package com.gym.management.domain.category.service

import com.gym.management.domain.category.model.ProductCategoryMapper.toDto
import com.gym.management.domain.category.model.ProductCategoryMapper.toEntity
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.repository.ProductCategoryRepository
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DCategoryService(
    private val productCategoryRepository: ProductCategoryRepository,
) {
    @Transactional
    fun upsertProductCategory(productCategoryList: List<ProductCategoryDTO>): Boolean {
        productCategoryRepository.bulkUpsertProductCategory(productCategoryList.map { it.toEntity() })
        return true
    }

    fun findProductCategoryBy(branchId: Int): List<ProductCategoryDTO> {
        return productCategoryRepository.findByBranchId(branchId).map { it.toDto() }
    }

    companion object : KLogging()
}