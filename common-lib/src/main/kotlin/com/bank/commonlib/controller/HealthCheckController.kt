package com.bank.commonlib.controller

import com.bank.commonlib.dto.HealthResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthCheckController {
    @GetMapping("/check")
    fun healthCheck(): ResponseEntity<HealthResponse> {
        return try {
            ResponseEntity.ok(HealthResponse("App ok"))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(HealthResponse("App error: ${e.message}"))
        }
    }

}