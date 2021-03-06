package com.example.android_mvvm_best_pratices.data

import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {

    suspend fun doRegister(registerRequest: RegisterRequest): Flow<Resource<User>>
}