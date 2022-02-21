package com.example.android_mvvm_best_pratices.data.remote

import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest

interface RemoteDataSource {
    suspend fun register(registerRequest: RegisterRequest):Any?
    suspend fun login(loginRequest: LoginRequest):Any?

}
