package com.bank.userservice.infastructure.entity

import com.bank.userservice.core.domain.User
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "users", schema = "users")
data class UserEntity(
    @Id
    val id: UUID,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(name = "phone_number", unique = true, nullable = false)
    val phoneNumber: String,

    @Column(nullable = false)
    val birthday: LocalDate,

    @Column(name = "password_hash", nullable = false)
    val passwordHash: String?,

    @Column
    val role: String = "USER",

    @Column
    val status: String = "ACTIVE",

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)

fun User.toEntity(passwordHash: String?): UserEntity {
    return UserEntity(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        phoneNumber = this.phoneNumber,
        birthday = LocalDate.parse(this.birthday),
        passwordHash = passwordHash,
        role = "USER",
        status = "ACTIVE",
        createdAt = LocalDateTime.now()
    )
}