package com.example.diveintocleanarchitecture.domain.usecase

import com.example.diveintocleanarchitecture.domain.models.UserName
import com.example.diveintocleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}