package com.gym.management.domain.auth.service

import com.gym.management.common.component.JwtComponent
import com.gym.management.common.utils.UserUtils
import com.gym.management.config.exception.custom.user.LoginFailedException
import com.gym.management.domain.auth.model.dto.LoginFormDTO
import com.gym.management.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class DAuthService(
    private val userRepository: UserRepository,
    private val jwtComponent: JwtComponent
) {
    fun login(loginFormDTO: LoginFormDTO): String {
        val user = userRepository.findById(loginFormDTO.userId)
            .orElseThrow { LoginFailedException() }
        if (UserUtils.hashSHA256(loginFormDTO.password) != user.userPassword) throw LoginFailedException()
        return jwtComponent.generateToken(user.userId)
    }
}