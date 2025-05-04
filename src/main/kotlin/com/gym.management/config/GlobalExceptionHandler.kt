package com.gym.management.config

import com.gym.management.model.ApiResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception, request: HttpServletRequest): ResponseEntity<Any> {
        return ResponseEntity(
            ApiResponse(
                code = "E000",
                errorMessage = "확인되지않은 오류입니다",
                data = null
            ), HttpStatus.OK
        )
    }
}