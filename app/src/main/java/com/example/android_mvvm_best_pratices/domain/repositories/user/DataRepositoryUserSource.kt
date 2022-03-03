package com.example.android_mvvm_best_pratices.domain.repositories.user

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.domain.model.user.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DataRepositoryUserSource {

    suspend fun doRegister(registerRequest: RegisterRequest): Response<User>
    suspend fun doLogin(loginRequest: LoginRequest): Response<LoginResponse>
}