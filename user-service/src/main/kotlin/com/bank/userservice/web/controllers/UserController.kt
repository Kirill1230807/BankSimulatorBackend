package com.bank.userservice.web.controllers

import com.bank.userservice.api.dto.UserRegistrationRequest
import com.bank.userservice.core.service.RegistrationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val registrationService: RegistrationService
) {
    @PostMapping("/register")
    fun register(@Valid @RequestBody request: UserRegistrationRequest): ResponseEntity<String> {
        registrationService.registerUser(request)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Користувач успішно зареєстрований")
    }
}