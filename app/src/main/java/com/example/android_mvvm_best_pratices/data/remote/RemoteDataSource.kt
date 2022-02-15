package com.example.android_mvvm_best_pratices.data.remote

import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest

interface RemoteDataSource {
    suspend fun register(registerRequest: RegisterRequest):Any?

}
