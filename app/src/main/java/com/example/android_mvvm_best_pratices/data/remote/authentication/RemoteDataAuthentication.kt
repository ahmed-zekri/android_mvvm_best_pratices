package com.example.android_mvvm_best_pratices.data.remote.authentication

import com.example.android_mvvm_best_pratices.ERROR_DELIMITER
import com.example.android_mvvm_best_pratices.NO_INTERNET_CONNECTION_ERROR
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.data.remote.ServiceGenerator
import com.example.android_mvvm_best_pratices.ui.component.base.BaseRemoteData
import javax.inject.Inject

class RemoteDataAuthentication @Inject
constructor(serviceGenerator: ServiceGenerator) : RemoteDataSourceAuthentication, BaseRemoteData(
    serviceGenerator
) {


    override suspend fun register(registerRequest: RegisterRequest): Resource<User> {

        return when (val response = processCall {
            authService.register(
                registerRequest
            )
        }) {
            is User -> Resource.Success(data = response)
            is Int -> Resource.InternetError(
                error = response,
                message = NO_INTERNET_CONNECTION_ERROR
            )
            else -> {
                response as String
                Resource.ServerError(
                    error = response.split(ERROR_DELIMITER)[0].toInt(),
                    message = response.split(ERROR_DELIMITER)[1]
                )
            }
        }


    }

    override suspend fun login(loginRequest: LoginRequest): Resource<LoginResponse> {

        return when (val response = processCall { authService.login(loginRequest) }) {
            is Int -> Resource.ServerError(
                error = response,
                message = NO_INTERNET_CONNECTION_ERROR
            )
            is LoginResponse -> Resource.Success(data = response)
            else -> {
                response as String
                Resource.ServerError(
                    error = response.split(ERROR_DELIMITER)[0].toInt(),
                    message = response.split(ERROR_DELIMITER)[1]
                )
            }

        }

    }


}


