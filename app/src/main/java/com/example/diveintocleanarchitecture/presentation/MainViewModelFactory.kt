package com.example.diveintocleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.domain.usecase.GetUserNameUseCase
import com.example.domain.domain.usecase.SaveUserNameUseCase


class MainViewModelFactory(
    val saveUserNameUseCase: SaveUserNameUseCase,
    val getUserNameUseCase: GetUserNameUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(saveUserNameUseCase, getUserNameUseCase) as T
    }
}