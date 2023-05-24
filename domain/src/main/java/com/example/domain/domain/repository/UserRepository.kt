package com.example.domain.domain.repository

import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}