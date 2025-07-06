package com.gym.management.domain.category.repository

import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCategoryRepository : JpaRepository<ProductCategory, ProductCategoryId> {
    fun findByBranchId(branchId: Int): MutableList<ProductCategory>
}