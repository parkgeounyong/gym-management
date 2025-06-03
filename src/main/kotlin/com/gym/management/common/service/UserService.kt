package com.gym.management.common.service

import com.gym.management.common.model.user.dto.UserDTO
import com.gym.management.common.model.user.entity.User
import com.gym.management.common.repository.user.UserRepository
import com.gym.management.config.exception.custom.user.DuplicateIdException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun createUser(userDTO: UserDTO): UserDTO {
        checkRegisterPossible(userDTO)
        val result = userRepository.save(User(userDTO))
        return UserDTO(result)
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}