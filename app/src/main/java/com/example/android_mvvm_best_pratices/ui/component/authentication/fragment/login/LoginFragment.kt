package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.login

import androidx.activity.viewModels
import com.example.android_mvvm_best_pratices.databinding.ActivityLoginBinding
import com.example.android_mvvm_best_pratices.ui.component.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun observeViewModel() {
        viewModel.registerStatus.observe(this) {

        }
    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

    }


}