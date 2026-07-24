package com.bank.userservice.infastructure.jwt

import com.bank.userservice.infastructure.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email) ?: throw UsernameNotFoundException("Користувача $email не знайдено!")

        return User.builder()
            .username(user.email)
            .password(user.passwordHash)
            .roles(user.role.toString())
            .build()
    }
}