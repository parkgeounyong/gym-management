package com.gym.management.common.utils

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.util.*
import javax.crypto.SecretKey

object JwtUtils {
    private lateinit var secretKey: String
    private var expired: Int? = null

    fun init(secretKey: String, expired: Int) {
        this.secretKey = secretKey
        this.expired = expired

    }

    fun generateToken(userId: String): String {
        val signingKey: SecretKey = Keys.hmacShaKeyFor(secretKey.toByteArray())
        val now = Date()
        val expiryDate = Date(now.time + expired!!)
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