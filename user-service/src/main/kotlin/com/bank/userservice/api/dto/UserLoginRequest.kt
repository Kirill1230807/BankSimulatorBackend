package com.bank.userservice.api.dto

data class UserLoginRequest(
    val email: String,
    val password: String
)
