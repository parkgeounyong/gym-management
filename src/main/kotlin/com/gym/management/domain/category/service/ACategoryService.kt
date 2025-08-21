package com.gym.management.domain.category.service

import com.gym.management.domain.category.repository.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class ACategoryService(
    private val categoryRepository: ProductCategoryRepository
) {
}