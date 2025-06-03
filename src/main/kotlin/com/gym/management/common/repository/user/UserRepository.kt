package com.gym.management.common.repository.user

import com.gym.management.common.model.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun existsUserByUserId(userId: String): Boolean
}