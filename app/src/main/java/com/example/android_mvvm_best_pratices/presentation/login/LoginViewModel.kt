package com.example.android_mvvm_best_pratices.presentation.login

import androidx.lifecycle.MutableLiveData
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.domain.usecase.authentication.LoginUseCase
import com.example.android_mvvm_best_pratices.domain.usecase.authentication.invoke
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) {
    val loginRequest = MutableLiveData<LoginRequest>()
    private fun login() = loginUseCase(loginRequest = loginRequest.value)

}