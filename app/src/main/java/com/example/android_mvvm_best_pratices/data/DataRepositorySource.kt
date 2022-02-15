package com.example.android_mvvm_best_pratices.data

import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest
import java.util.concurrent.Flow

interface DataRepositorySource {
    suspend fun doRegister(registerRequest: RegisterRequest):Flow
}