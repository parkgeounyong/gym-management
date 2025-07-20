package com.gym.management.domain.category.service

import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import com.gym.management.domain.category.repository.ProductCategoryRepository
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DCategoryService(
    private val productCategoryRepository: ProductCategoryRepository
) {
    fun createProductCategory(productCategoryDTO: ProductCategoryDTO): ProductCategoryDTO {
        val result = productCategoryRepository.save(ProductCategory(productCategoryDTO))
        return ProductCategoryDTO(result)
    }

    @Transactional
    fun updateProductCategory(productCategoryList: List<ProductCategoryDTO>): Boolean {
        val idList = productCategoryList.map { ProductCategoryId(it.productCategoryCode, it.branchId) }
        val entityMap =
            productCategoryRepository.findAllById(idList).associateBy { ProductCategoryId(it.procaCode, it.branchId) }

        productCategoryList.forEach { productCategoryDTO ->
            entityMap[ProductCategoryId(productCategoryDTO.productCategoryCode, productCategoryDTO.branchId)]?.updateBy(
                productCategoryDTO
            ) ?: logger.warn { "Product category not found when update. branchId=${productCategoryDTO.branchId}, categoryCode=${productCategoryDTO.productCategoryCode}" }
        }
        return true
    }

    fun findProductCategoryBy(branchId: Int): List<ProductCategoryDTO> {
        return productCategoryRepository.findByBranchId(branchId).map { ProductCategoryDTO(it) }
    }

    companion object : KLogging()
}