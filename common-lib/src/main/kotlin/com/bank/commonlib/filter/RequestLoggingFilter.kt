package com.bank.commonlib.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class RequestLoggingFilter : OncePerRequestFilter() {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val startTime = System.currentTimeMillis()

        filterChain.doFilter(request, response)

        val duration = System.currentTimeMillis() - startTime

        log.info(
            "HTTP Request: [{}] {} - Status: {} ({}ms)",
            request.method,
            request.requestURI,
            response.status,
            duration
        )
    }
}