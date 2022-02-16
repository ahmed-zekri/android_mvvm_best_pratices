package com.example.android_mvvm_best_pratices.data

import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest

interface DataRepositorySource {

    suspend fun doRegister(registerRequest: RegisterRequest):kotlinx.coroutines.flow.Flow<Any?>
}