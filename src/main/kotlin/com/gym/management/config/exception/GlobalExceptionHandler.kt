package com.gym.management.config.exception

import com.gym.management.common.model.ApiResponse
import com.gym.management.config.exception.custom.DomainException
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
        logger.error("Exception occurred", e)
        return ResponseEntity(
            ApiResponse(
                code = "E000",
                errorMessage = "확인되지않은 오류입니다",
                data = null
            ), HttpStatus.OK
        )
    }

    @ExceptionHandler(DomainException::class)
    fun handleDomainException(e: DomainException, request: HttpServletRequest): ResponseEntity<Any> {
        return ResponseEntity(
            ApiResponse(
                code = e.code,
                errorMessage = e.message,
                data = null
            ), HttpStatus.OK
        )
    }
    companion object : KLogging()
}