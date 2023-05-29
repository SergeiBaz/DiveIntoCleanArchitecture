package com.example.diveintocleanarchitecture.presentation.app

import android.app.Application
import com.example.diveintocleanarchitecture.presentation.di.AppComponent
import com.example.diveintocleanarchitecture.presentation.di.AppModule
import com.example.diveintocleanarchitecture.presentation.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}