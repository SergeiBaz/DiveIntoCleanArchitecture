package com.example.diveintocleanarchitecture.presentation.di

import android.content.Context
import com.example.diveintocleanarchitecture.presentation.MainViewModelFactory
import com.example.domain.domain.usecase.GetUserNameUseCase
import com.example.domain.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        saveUserNameUseCase: SaveUserNameUseCase,
        getUserNameUseCase: GetUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(saveUserNameUseCase, getUserNameUseCase)
    }
}