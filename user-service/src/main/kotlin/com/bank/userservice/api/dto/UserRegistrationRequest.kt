package com.bank.userservice.api.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Запит на реєстрацію нового користувача")
data class UserRegistrationRequest(

    @Schema(description = "Ім'я", example = "Петро")
    val firstName: String,

    @Schema(description = "Прізвище", example = "Петренко")
    val lastName: String,

    @Schema(description = "Пошта", example = "petro.petrenko@gmail.com")
    val email: String,

    @Schema(description = "Номер телефону", example = "+380501234576")
    val phoneNumber: String,

    @Schema(description = "Дата народження", example = "1990-12-25")
    val birthday: String,

    @Schema(description = "Пароль", example = "StrongPassword2026!")
    val password: String
)
