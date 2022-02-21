package com.example.android_mvvm_best_pratices.data.repositories.user

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import kotlinx.coroutines.flow.Flow

interface DataRepositoryUserSource {

    suspend fun doRegister(registerRequest: RegisterRequest): Flow<Resource<User>>
    suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<LoginResponse>>
}