package com.bank.userservice.core.service

import com.bank.userservice.api.dto.UserRegistrationRequest
import com.bank.userservice.core.domain.User
import com.bank.userservice.infastructure.entity.toEntity
import com.bank.userservice.infastructure.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class RegistrationService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun registerUser(request: UserRegistrationRequest) {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("Користувач з таким email вже існує")
        }

        val newUser = User(
            id = UUID.randomUUID(),
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            phoneNumber = request.phoneNumber,
            birthday = request.birthday
        )

        val passwordHash = passwordEncoder.encode(request.password)
        val userEntity = newUser.toEntity(passwordHash)
        userRepository.save(userEntity)
    }
}