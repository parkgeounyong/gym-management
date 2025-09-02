package com.gym.management.domain.user.model

import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.user.model.entity.User
import java.time.LocalDateTime

object UserMapper {
    fun UserDTO.toEntity(): User =
        User(
            userId = this.userId,
            userPassword = this.userPassword,
            userRole = this.userRole,
            userName = this.userName,
            userPhone = this.userPhone,
            userEmail = this.userEmail,
            userCreatedAt = LocalDateTime.now(),
            userUpdatedAt = LocalDateTime.now(),
            userDeleted = 'N',
        )

    fun User.update(userDTO: UserDTO): User {
        userName = userDTO.userName
        userPhone = userDTO.userPhone
        userEmail = userDTO.userEmail
        userUpdatedAt = userDTO.userUpdatedAt
        return this
    }
}