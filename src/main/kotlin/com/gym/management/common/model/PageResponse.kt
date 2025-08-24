package com.gym.management.common.model

data class PageResponse<T>(
    val totalCount: Int,
    val totalPages: Int,
    val page: Int,
    val size: Int,
    val sortBy: String,
    val direction: String,
    val items: List<T> = emptyList(),
)