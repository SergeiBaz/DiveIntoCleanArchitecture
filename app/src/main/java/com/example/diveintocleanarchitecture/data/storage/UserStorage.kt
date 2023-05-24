package com.example.diveintocleanarchitecture.data.storage

import com.example.diveintocleanarchitecture.data.storage.model.User

interface UserStorage {
    fun saveUser(user: User): Boolean
    fun getUser(): User
}