package com.gym.management.domain.category.service

import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import com.gym.management.domain.category.repository.ProductCategoryRepository
import jakarta.persistence.EntityManager
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DCategoryService(
    private val productCategoryRepository: ProductCategoryRepository,
    private val entityManager: EntityManager
) {
    @Transactional
    fun upsertProductCategory(productCategoryList: List<ProductCategoryDTO>): Boolean {
        val idList = productCategoryList.map { ProductCategoryId(it.productCategoryCode, it.branchId) }
        val existingEntities =
            productCategoryRepository.findAllById(idList).associateBy { ProductCategoryId(it.procaCode, it.branchId) }

        val toInsert = mutableListOf<ProductCategory>()

        productCategoryList.forEach { dto ->
            val key = ProductCategoryId(dto.productCategoryCode, dto.branchId)
            val entity = existingEntities[key]
            if (entity != null) {
                entity.updateBy(dto)
            } else {
                toInsert.add(ProductCategory(dto))
            }
        }

        toInsert.forEachIndexed { index, entity ->
            entityManager.persist(entity)
            if (index % 100 == 0) {
                entityManager.flush()
                entityManager.clear()
            }
        }
        return true
    }

    fun findProductCategoryBy(branchId: Int): List<ProductCategoryDTO> {
        return productCategoryRepository.findByBranchId(branchId).map { ProductCategoryDTO(it) }
    }

    companion object : KLogging()
}