package com.gym.management.config.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.gym.management.common.model.ApiResponse
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KLogging
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter


@Component
class ExceptionHandlerFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            handleAuthenticationException(response, "SE001", "알 수 없는 오류입니다", e)
        }
    }

    private fun handleAuthenticationException(
        response: HttpServletResponse, code: String, message: String, e: Exception
    ) {
        response.status = 200
        response.contentType = "application/json;charset=UTF-8"

        logger.error("error in security filter", e)

        val responseBody = ApiResponse(
            code = code,
            errorMessage = message,
            data = null
        )

        response.writer.use { writer ->
            writer.write(objectMapper.writeValueAsString(responseBody))
        }
    }

    companion object : KLogging()
}