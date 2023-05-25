package com.example.diveintocleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.shared_pref.SharedPrefsUserStorage
import com.example.domain.domain.usecase.GetUserNameUseCase
import com.example.domain.domain.usecase.SaveUserNameUseCase


class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userRepositoryImpl by lazy {
        UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context))
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(userRepositoryImpl)
    }
    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(userRepositoryImpl)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(saveUserNameUseCase, getUserNameUseCase) as T
    }
}