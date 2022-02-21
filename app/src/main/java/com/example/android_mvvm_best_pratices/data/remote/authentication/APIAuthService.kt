package com.example.android_mvvm_best_pratices.data.remote.authentication

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIAuthService {

    @POST("auth/signup")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<User>


    @POST("auth/signin")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>


}