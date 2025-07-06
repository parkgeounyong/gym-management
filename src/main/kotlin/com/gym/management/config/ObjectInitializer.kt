package com.gym.management.config

import com.gym.management.common.utils.JwtUtils
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ObjectInitializer(
    @Value("\${jwt.secret}")
    private val secretKey: String,
    @Value("\${jwt.expired}")
    private val expired: Int,
) {
    @PostConstruct
    fun init() {
        JwtUtils.init(secretKey, expired)
    }
}