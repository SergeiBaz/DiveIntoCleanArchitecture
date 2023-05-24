package com.example.domain.domain.usecase

import com.example.domain.domain.models.UserName
import com.example.domain.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}