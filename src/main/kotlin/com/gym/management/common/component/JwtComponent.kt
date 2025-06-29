package com.gym.management.common.component

import io.jsonwebtoken.Claims
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
        val claims = mapOf("userId" to userId)
        return Jwts.builder()
            .claims(claims)
            .subject(userId)
            .issuedAt(now)
            .expiration(expiryDate)
            .signWith(signingKey)
            .compact()
    }

    fun buildClaims(authorizationHeader: String): Claims {
        val token = authorizationHeader.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        val signingKey: SecretKey = Keys.hmacShaKeyFor(secretKey.toByteArray())

        return Jwts.parser()
            .verifyWith(signingKey)
            .build()
            .parseSignedClaims(token)
            .payload
    }
}