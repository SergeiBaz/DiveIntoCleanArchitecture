package com.example.diveintocleanarchitecture.domain.usecase

import com.example.diveintocleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}