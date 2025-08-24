package com.gym.management.domain.category.repository

import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.entity.id.ProductCategoryId
import org.springframework.data.jpa.repository.JpaRepository

interface ProductCategoryRepository : JpaRepository<ProductCategory, ProductCategoryId>, ProductCategoryRepositoryCustom {
    fun findByBranchId(branchId: Int): MutableList<ProductCategory>
}