package com.example.diveintocleanarchitecture.presentation.di

import com.example.diveintocleanarchitecture.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}