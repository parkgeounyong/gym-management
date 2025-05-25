package com.gym.management.common.service

import com.gym.management.common.model.user.dto.UserDTO
import com.gym.management.common.model.user.entity.User
import com.gym.management.common.repository.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun createUser(userDTO: UserDTO): UserDTO {
        val result = userRepository.save(User(userDTO))
        return UserDTO(result)
    }
}