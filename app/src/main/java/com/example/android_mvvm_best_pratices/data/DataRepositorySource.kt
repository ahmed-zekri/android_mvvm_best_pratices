package com.example.android_mvvm_best_pratices.data

import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest
import dagger.Provides
import java.util.concurrent.Flow

interface DataRepositorySource {
    @Provides
    suspend fun doRegister(registerRequest: RegisterRequest):kotlinx.coroutines.flow.Flow<Any?>
}