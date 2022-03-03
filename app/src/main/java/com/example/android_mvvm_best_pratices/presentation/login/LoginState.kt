package com.example.android_mvvm_best_pratices.presentation.login

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest

data class LoginState(

    val isLoading: Boolean?,
    val login: LoginRequest?, val error: String?

)
