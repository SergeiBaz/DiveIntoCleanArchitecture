package com.example.diveintocleanarchitecture.domain.repository

import com.example.diveintocleanarchitecture.domain.models.SaveUserNameParam
import com.example.diveintocleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}