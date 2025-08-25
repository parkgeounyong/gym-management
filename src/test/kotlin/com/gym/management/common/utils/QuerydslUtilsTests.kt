package com.gym.management.common.utils

import com.gym.management.domain.user.model.entity.QUser
import com.querydsl.core.types.Order
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class QuerydslUtilsTests : BehaviorSpec({
    given("createSort(entity: EntityPathBase<*>, sortBy: String, direction: String) 테스트") {
        val user = QUser.user
        `when`("direction이 ASC일 때") {
            val sort = QuerydslUtils.createSort(user, "name", "ASC")
            then("정렬 순서는 ASC여야 한다") {
                sort.order shouldBe Order.ASC
            }
        }
        `when`("direction이 DESC일 때") {
            val sort = QuerydslUtils.createSort(user, "name", "DESC")
            then("정렬 순서는 DESC여야 한다") {
                sort.order shouldBe Order.DESC
            }
        }
        `when`("정렬대상이 name일 때") {
            val sort = QuerydslUtils.createSort(user, "name", "ASC")
            then("정렬 대상이 name이여야 한다") {
                sort.target.toString() shouldContain "name"
            }
        }
        `when`("정렬대상이 userCreatedAt일 때") {
            val sort = QuerydslUtils.createSort(user, "userCreatedAt", "ASC")
            then("정렬 대상이 userCreatedAt이여야 한다") {
                sort.target.toString() shouldContain "userCreatedAt"
            }
        }
    }
})