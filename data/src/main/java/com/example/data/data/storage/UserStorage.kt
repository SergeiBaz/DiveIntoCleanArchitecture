package com.example.data.data.storage

import com.example.data.data.storage.model.User

interface UserStorage {
    fun saveUser(user: User): Boolean
    fun getUser(): User
}