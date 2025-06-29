package com.gym.management.config.security.filter

import com.gym.management.common.component.JwtComponent
import com.gym.management.domain.user.model.dto.UserInfoDTO
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtComponent: JwtComponent
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
        if (authorizationHeader == null) {
            filterChain.doFilter(request, response)
            return
        }
        val claims = jwtComponent.buildClaims(authorizationHeader)
        val userInfo = UserInfoDTO(
            userId = claims["userId"].toString(),
        )

        val authenticationToken =
            UsernamePasswordAuthenticationToken(
                userInfo,
                null,
                null
            )
        authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authenticationToken
        filterChain.doFilter(request, response)
    }
}