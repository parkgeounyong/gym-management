package com.gym.management.common.utils

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.EntityPathBase
import com.querydsl.core.types.dsl.PathBuilder
import com.querydsl.core.types.dsl.SimpleExpression

object QuerydslUtils {
    fun createSort(
        entity: EntityPathBase<*>,
        sortBy: String,
        direction: String,
    ): OrderSpecifier<*>{
        val pathBuilder = PathBuilder(entity.type, entity.metadata)
        val order = if (direction == "DESC") Order.DESC else Order.ASC
        return OrderSpecifier(order, pathBuilder.get(sortBy, Comparable::class.java))
    }

    fun <T> buildEqualsIfPresent(path: SimpleExpression<T>, value: T?): BooleanBuilder {
        return BooleanBuilder().apply {
            value?.let { and(path.eq(it)) }
        }
    }
}