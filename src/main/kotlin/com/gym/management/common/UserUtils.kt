package com.gym.management.common

import java.security.MessageDigest

object UserUtils {
    /**
     * 입력값에 대해 해싱한 값을 반환합니다
     *
     * @param input 해싱하고자하는 값
     * @return input에 대한 해싱한 값
     */
    fun hashSHA256(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}