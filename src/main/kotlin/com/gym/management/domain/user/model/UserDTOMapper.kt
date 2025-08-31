package com.gym.management.domain.user.model

import com.gym.management.common.utils.UserUtils
import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.user.model.request.DCreateUserRequest
import com.gym.management.domain.user.model.request.DUpdateUserRequest
import java.time.LocalDateTime

object UserDTOMapper {
    fun DCreateUserRequest.toUserDTO(): UserDTO =
        UserDTO(
            userId = this.userId,
            userPassword = UserUtils.hashSHA256(this.userPassword),
            userRole = this.userRole,
            userName = this.userName,
            userPhone = this.userPhone,
            userEmail = this.userEmail,
            userCreatedAt = LocalDateTime.now(),
            userUpdatedAt = LocalDateTime.now(),
            userDeleted = 'N'
        )

    fun DUpdateUserRequest.toUserDTO(): UserDTO =
        UserDTO(
            userId = this.userId,
            userPassword = UserUtils.hashSHA256(this.userPassword),
            userRole = this.userRole,
            userName = this.userName,
            userPhone = this.userPhone,
            userEmail = this.userEmail,
            userCreatedAt = LocalDateTime.now(),
            userUpdatedAt = LocalDateTime.now(),
            userDeleted = 'N'
        )
}