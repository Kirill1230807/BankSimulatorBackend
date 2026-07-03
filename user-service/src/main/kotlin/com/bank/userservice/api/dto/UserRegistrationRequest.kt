package com.bank.userservice.api.dto

data class UserRegistrationRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val birthday: String,
    val password: String
)
