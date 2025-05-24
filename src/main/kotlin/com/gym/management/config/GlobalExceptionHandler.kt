package com.gym.management.config

import com.gym.management.common.model.util.ApiResponse
import jakarta.servlet.http.HttpServletRequest
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception, request: HttpServletRequest): ResponseEntity<Any> {
        logger.error(e.message)
        return ResponseEntity(
            ApiResponse(
                code = "E000",
                errorMessage = "확인되지않은 오류입니다",
                data = null
            ), HttpStatus.OK
        )
    }
    companion object : KLogging()
}