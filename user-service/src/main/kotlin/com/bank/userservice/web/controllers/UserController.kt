package com.bank.userservice.web.controllers

import com.bank.userservice.api.dto.UserLoginRequest
import com.bank.userservice.api.dto.UserRegistrationRequest
import com.bank.userservice.core.service.AuthService
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
    private val registrationService: RegistrationService,
    private val authService: AuthService
) {
    @PostMapping("/register")
    fun register(@Valid @RequestBody request: UserRegistrationRequest): ResponseEntity<String> {

        registrationService.registerUser(request)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Користувач успішно зареєстрований")
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: UserLoginRequest): ResponseEntity<String> {

        val result = authService.login(request)

        return ResponseEntity.ok(result)
    }
}