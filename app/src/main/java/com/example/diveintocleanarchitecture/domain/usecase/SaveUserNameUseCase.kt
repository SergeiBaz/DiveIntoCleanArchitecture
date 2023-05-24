package com.example.diveintocleanarchitecture.domain.usecase

import com.example.diveintocleanarchitecture.domain.models.SaveUserNameParam
import com.example.diveintocleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(param)
    }
}