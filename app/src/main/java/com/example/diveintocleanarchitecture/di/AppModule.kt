package com.example.diveintocleanarchitecture.di

import com.example.diveintocleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(saveUserNameUseCase = get(), getUserNameUseCase = get())
    }
}