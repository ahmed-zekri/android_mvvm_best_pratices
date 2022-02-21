package com.example.android_mvvm_best_pratices.data.repositories.user

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.data.remote.authentication.RemoteDataAuthentication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepositoryUserUserImpl @Inject constructor(
    private val remoteRepositoryAuthentication: RemoteDataAuthentication,
    private val ioDispatcher: CoroutineContext
) :
    DataRepositoryUserSource {
    override suspend fun doRegister(registerRequest: RegisterRequest): Flow<Resource<User>> {
        return flow {

            emit(remoteRepositoryAuthentication.register(registerRequest))

        }.flowOn(ioDispatcher)

    }

    override suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<LoginResponse>> {
        return flow {

            emit(remoteRepositoryAuthentication.login(loginRequest))


        }.flowOn(ioDispatcher)

    }
}