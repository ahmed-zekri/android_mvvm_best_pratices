package com.example.android_mvvm_best_pratices.ui.component.login

import android.os.Bundle
import com.example.android_mvvm_best_pratices.databinding.ActivityLoginBinding
import com.example.android_mvvm_best_pratices.ui.component.base.BaseActivity

class LoginActivity : BaseActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun observeViewModel() {
        TODO("Not yet implemented")
    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}