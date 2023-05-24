package com.example.data.data.repository

import com.example.data.data.storage.UserStorage
import com.example.data.data.storage.model.User
import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.models.UserName
import com.example.domain.domain.repository.UserRepository

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