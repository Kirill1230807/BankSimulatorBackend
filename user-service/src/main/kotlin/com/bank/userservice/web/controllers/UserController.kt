package com.bank.userservice.web.controllers

import com.bank.userservice.api.dto.AuthResponse
import com.bank.userservice.api.dto.UserLoginRequest
import com.bank.userservice.api.dto.UserRegistrationRequest
import com.bank.userservice.core.service.AuthService
import com.bank.userservice.core.service.RegistrationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "User Service API", description = "Управління користувачами")
@RequestMapping("/api/v1/users")
class UserController(
    private val registrationService: RegistrationService,
    private val authService: AuthService
) {

    @Operation(
        summary = "Реєстрація користувача",
        description = "Реєструє користувача в системі, робить запис у базу даних."
    )
    @PostMapping("/register")
    fun register(@Valid @RequestBody request: UserRegistrationRequest): ResponseEntity<String> {

        registrationService.registerUser(request)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Користувач успішно зареєстрований")
    }

    @Operation(
        summary = "Вхід в аккаунт користувача",
        description = "Авторизація користувача в системі. Користувач повинен мати зареєстрований аккаунт в системі."
    )
    @PostMapping("/login")
    fun login(@Valid @RequestBody request: UserLoginRequest): ResponseEntity<AuthResponse> {

        val result = authService.login(request)

        return ResponseEntity.ok(result)
    }
}