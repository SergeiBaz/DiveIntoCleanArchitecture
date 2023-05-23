package com.example.diveintocleanarchitecture.domain.usecase

import com.example.diveintocleanarchitecture.domain.models.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName("Ivan", "Ivanov")
    }
}