package com.gym.management.domain.user.repository

import com.gym.management.domain.user.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
    fun existsUserByUserId(userId: String): Boolean
}