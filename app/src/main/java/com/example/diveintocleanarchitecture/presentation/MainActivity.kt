package com.example.diveintocleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.diveintocleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]
        vm.liveData.observe(this) { text ->
            binding.dataTextView.text = text
        }

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            vm.save(text)
        }

        binding.receiveButton.setOnClickListener {
            vm.load()
        }
    }
}