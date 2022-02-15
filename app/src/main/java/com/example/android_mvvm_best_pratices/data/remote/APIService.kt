package com.example.android_mvvm_best_pratices.data.remote

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET

interface APIService {

    @GET("register")
    suspend fun register(
        @Field("username")
        login: String,
        @Field("password")
        password: String,
        @Field("role") role: String
    ): Response<*>

}