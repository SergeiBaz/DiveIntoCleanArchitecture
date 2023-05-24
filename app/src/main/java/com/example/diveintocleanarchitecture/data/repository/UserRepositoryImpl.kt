package com.example.diveintocleanarchitecture.data.repository

import com.example.diveintocleanarchitecture.data.storage.UserStorage
import com.example.diveintocleanarchitecture.data.storage.model.User
import com.example.diveintocleanarchitecture.domain.models.SaveUserNameParam
import com.example.diveintocleanarchitecture.domain.models.UserName
import com.example.diveintocleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return userStorage.saveUser(mapToStorage(saveParam))
    }

    override fun getName(): UserName {
        val user = userStorage.getUser()
        return mapToDomain(user)
    }
}

private fun mapToDomain(user: User): UserName {
    return UserName(user.firstName, user.lastName)
}

private fun mapToStorage(user: SaveUserNameParam): User {
    return User(user.name, "")
}