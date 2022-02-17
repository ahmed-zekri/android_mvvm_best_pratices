package com.example.android_mvvm_best_pratices.ui.component.login

import android.widget.Toast
import androidx.activity.viewModels
import com.example.android_mvvm_best_pratices.databinding.ActivityLoginBinding
import com.example.android_mvvm_best_pratices.ui.component.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()
    override fun observeViewModel() {
 
    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

    }


}