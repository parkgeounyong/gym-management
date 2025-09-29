package com.gym.management.domain.auth

import com.gym.management.common.utils.JwtUtils
import com.gym.management.common.utils.UserUtils
import com.gym.management.config.exception.custom.user.LoginFailedException
import com.gym.management.domain.auth.model.dto.LoginFormDTO
import com.gym.management.domain.auth.service.AuthService
import com.gym.management.domain.user.model.entity.User
import com.gym.management.domain.user.repository.UserRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.types.shouldBeTypeOf
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDateTime
import java.util.Optional

class AuthServiceTests : BehaviorSpec({
    beforeSpec {
        JwtUtils.init("dGVzdC1zZWNyZXQta2V5LXN0cnVjdHVyZS1mb3ItVGVzdGluZy0xMjM0NTY=", 86400000)
    }

    val userRepository = mockk<UserRepository>()
    val authService = AuthService(userRepository)
    given("AuthService.login() 분기 테스트") {
        `when`("아이디가 존재하지 않으면") {
            then("LoginFailedException을 던진다") {
                every { userRepository.findById("no_user") } returns Optional.empty()
                shouldThrow<LoginFailedException> {
                    authService.login(LoginFormDTO("no_user", "1234"))
                }
            }
        }

        `when`("비밀번호가 틀리면") {
            then("LoginFailedException을 던진다") {
                val user = User(
                    userId = "userId",
                    userPassword = "PW1234",
                    userRole = "USER",
                    userName = "userName",
                    userPhone = "010-1234-5678",
                    userEmail = "test@example.com",
                    userCreatedAt = LocalDateTime.now(),
                    userUpdatedAt = LocalDateTime.now(),
                    userDeleted = 'N'
                )
                every { userRepository.findById("userId") } returns Optional.of(user)

                shouldThrow<LoginFailedException> {
                    authService.login(LoginFormDTO("userId", "wrong_pw"))
                }
            }
        }

        `when`("아이디와 비밀번호가 맞으면") {
            then("토큰이 발급되어야 한다") {
                val user = User(
                    userId = "valid_user",
                    userPassword = UserUtils.hashSHA256("correct_pw"),
                    userRole = "USER",
                    userName = "홍길동",
                    userPhone = "010-1234-5678",
                    userEmail = "test@example.com",
                    userCreatedAt = LocalDateTime.now(),
                    userUpdatedAt = LocalDateTime.now(),
                    userDeleted = 'N'
                )
                every { userRepository.findById("valid_user") } returns Optional.of(user)
                val result = authService.login(LoginFormDTO("valid_user", "correct_pw"))
                result.shouldBeTypeOf<String>()
            }
        }
    }
})