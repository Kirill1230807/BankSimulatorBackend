package com.bank.userservice.infastructure.repository

import com.bank.userservice.core.domain.User
import com.bank.userservice.infastructure.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): User?
    fun existsByPhoneNumber(phoneNumber: String): Boolean
}