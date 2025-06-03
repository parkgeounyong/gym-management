package com.gym.management.common.component

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtComponent(
    @Value("\${jwt.secret}")
    private val secretKey: String,
    @Value("\${jwt.expired}")
    private val expired: Int,
) {
    fun generateToken(userId: String): String {
        val signingKey: SecretKey = Keys.hmacShaKeyFor(secretKey.toByteArray())
        val now = Date()
        val expiryDate = Date(now.time + expired)
        return Jwts.builder()
            .subject(userId)
            .issuedAt(now)
            .expiration(expiryDate)
            .signWith(signingKey)
            .compact()
    }
}