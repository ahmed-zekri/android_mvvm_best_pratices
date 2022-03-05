package com.example.android_mvvm_best_pratices.domain.repositories.user

import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.domain.model.user.User
import retrofit2.Response

interface DataRepositoryUserSource {

    suspend fun doRegister(registerRequest: RegisterRequest): Response<User>
    suspend fun doLogin(loginRequest: LoginRequest?): Response<LoginResponse>
}