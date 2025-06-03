package com.gym.management.common.service

import com.gym.management.common.component.JwtComponent
import com.gym.management.common.utils.UserUtils
import com.gym.management.common.model.user.dto.LoginFormDTO
import com.gym.management.common.model.user.dto.UserDTO
import com.gym.management.common.model.user.entity.User
import com.gym.management.common.repository.user.UserRepository
import com.gym.management.config.exception.custom.user.DuplicateIdException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtComponent: JwtComponent
) {
    fun createUser(userDTO: UserDTO): UserDTO {
        checkRegisterPossible(userDTO)//todo 해싱 dto 변환시가 아닌 해당 로직에서 진행
        val result = userRepository.save(User(userDTO))
        return UserDTO(result)
    }

    fun login(loginFormDTO: LoginFormDTO): String {
        val user = userRepository.findById(loginFormDTO.userId)
            .orElseThrow { RuntimeException("User not found") }
        if (UserUtils.hashSHA256(loginFormDTO.password) != user.userPassword) throw RuntimeException("Wrong password")
        return jwtComponent.generateToken(user.userId)
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}