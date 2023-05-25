package com.example.diveintocleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.usecase.GetUserNameUseCase
import com.example.domain.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val liveDataMutable = MutableLiveData<String>()
    val liveData: LiveData<String> = liveDataMutable

    fun save(text: String) {
        val param = SaveUserNameParam(text)
        val result = saveUserNameUseCase.execute(param)
        liveDataMutable.value = "Result $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        liveDataMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}