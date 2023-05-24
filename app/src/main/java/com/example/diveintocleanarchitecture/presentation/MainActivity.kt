package com.example.diveintocleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diveintocleanarchitecture.data.repository.UserRepositoryImpl
import com.example.diveintocleanarchitecture.data.storage.UserStorage
import com.example.diveintocleanarchitecture.data.storage.shared_pref.SharedPrefsUserStorage
import com.example.diveintocleanarchitecture.databinding.ActivityMainBinding
import com.example.diveintocleanarchitecture.domain.models.SaveUserNameParam
import com.example.diveintocleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.diveintocleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userRepositoryImpl by lazy {
        UserRepositoryImpl(
            userStorage = SharedPrefsUserStorage(
                applicationContext
            )
        )
    }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepositoryImpl) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepositoryImpl) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val param = SaveUserNameParam(text)
            val result = saveUserNameUseCase.execute(param)
            binding.dataTextView.text = "Result $result"
        }

        binding.receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}