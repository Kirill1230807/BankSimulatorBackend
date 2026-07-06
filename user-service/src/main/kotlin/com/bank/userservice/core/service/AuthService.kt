package com.bank.userservice.core.service

import com.bank.userservice.api.dto.UserLoginRequest
import com.bank.userservice.infastructure.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository
) {
    @Transactional
    fun login(request: UserLoginRequest): String {
        val userEntity =
            userRepository.findByEmail(request.email) ?: throw IllegalArgumentException("Невірний email або пароль")

        if (!passwordEncoder.matches(request.password, userEntity.passwordHash)) {
            throw IllegalArgumentException("Невірний email або пароль")
        }

        return "Вхід успішний"
    }
}