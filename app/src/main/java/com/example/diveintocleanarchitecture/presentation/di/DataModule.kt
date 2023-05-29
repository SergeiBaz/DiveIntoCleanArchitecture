package com.example.diveintocleanarchitecture.presentation.di

import android.content.Context
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.UserStorage
import com.example.data.data.storage.shared_pref.SharedPrefsUserStorage
import com.example.domain.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefsUserStorage(context = context)
    }
}