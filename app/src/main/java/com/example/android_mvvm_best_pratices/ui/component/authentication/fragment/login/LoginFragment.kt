package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.login


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.databinding.FragmentLoginBinding
import com.example.android_mvvm_best_pratices.ui.component.base.BaseFragment
import com.example.android_mvvm_best_pratices.ui.component.home.activity.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun observeViewModel() {
        viewModel.loginStatus.observe(this) {
            if (it is Resource.Success)
                startActivity(Intent(context, HomeActivity::class.java))

        }
    }

    override fun initViewBinding(layoutInflater: LayoutInflater): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root

    }


}