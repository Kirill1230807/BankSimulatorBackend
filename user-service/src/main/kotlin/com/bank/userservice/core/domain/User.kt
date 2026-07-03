package com.bank.userservice.core.domain

import java.util.UUID

data class User(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val birthday: String,
)