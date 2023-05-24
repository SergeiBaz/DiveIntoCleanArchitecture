package com.example.domain.domain.usecase

import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(param)
    }
}