package com.example.android_mvvm_best_pratices.data.remote

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIAuthService {

    @POST("auth/signup")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<User>

}