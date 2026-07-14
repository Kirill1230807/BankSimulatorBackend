package com.bank.userservice.core.service

import com.bank.userservice.api.dto.AuthResponse
import com.bank.userservice.api.dto.UserLoginRequest
import com.bank.userservice.infastructure.jwt.JwtService
import com.bank.userservice.infastructure.repository.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {
    @Transactional
    fun login(request: UserLoginRequest): AuthResponse {
        val userEntity =
            userRepository.findByEmail(request.email) ?: throw IllegalArgumentException("Невірний email або пароль")

        if (!passwordEncoder.matches(request.password, userEntity.passwordHash)) {
            throw IllegalArgumentException("Невірний email або пароль")
        }

        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email, request.password
            )
        )

        val token = jwtService.generateToken(request.email)

        return AuthResponse(token)
    }
}