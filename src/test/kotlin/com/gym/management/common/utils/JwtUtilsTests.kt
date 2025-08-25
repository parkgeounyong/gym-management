package com.gym.management.common.utils

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class JwtUtilsTests : BehaviorSpec({
    val secret = "12345678901234567890123456789012"
    val expired = 1000 * 60 * 60
    JwtUtils.init(secret, expired)

    given("JwtUtils.generateToken(userId: String) 테스트") {
        `when`("userId=abc123 으로 토큰을 생성하면") {
            val token = JwtUtils.generateToken("abc123")
            then("토큰은 null 또는 빈 값이 아니어야 한다") {
                token.isNotBlank() shouldBe true
            }
        }
    }

    given("buildClaims(authorizationHeader: String) 테스트") {
        `when`("userId=abc123 으로 토큰을 생성하면") {
            val token = JwtUtils.generateToken("abc123")
            then("토큰을 파싱하면 userId=abc123 이 Claims에 있어야 한다") {
                val claims = JwtUtils.buildClaims("Bearer $token")
                claims["userId"] shouldBe "abc123"
                claims.subject shouldBe "abc123"
            }
        }
    }
})