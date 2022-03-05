package com.example.android_mvvm_best_pratices.data.repositories.user

import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.remote.authentication.APIAuthService
import com.example.android_mvvm_best_pratices.domain.repositories.user.DataRepositoryUserSource
import javax.inject.Inject

class DataRepositoryUserImpl @Inject constructor(
    private val apiAuthService: APIAuthService
) :
    DataRepositoryUserSource {
    override suspend fun doRegister(registerRequest: RegisterRequest) =
        apiAuthService.register(registerRequest)


    override suspend fun doLogin(loginRequest: LoginRequest?) = apiAuthService.login(loginRequest)


}