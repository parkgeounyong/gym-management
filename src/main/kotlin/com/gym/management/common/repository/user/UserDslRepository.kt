package com.gym.management.common.repository.user

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserDslRepository(
    private val queryFactory: JPAQueryFactory
) {

}