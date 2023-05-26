package com.example.diveintocleanarchitecture.di

import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.UserStorage
import com.example.data.data.storage.shared_pref.SharedPrefsUserStorage
import com.example.domain.domain.repository.UserRepository

import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}
