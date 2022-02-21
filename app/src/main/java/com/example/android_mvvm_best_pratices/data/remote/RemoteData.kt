package com.example.android_mvvm_best_pratices.data.remote

import com.example.android_mvvm_best_pratices.ERROR_DELIMITER
import com.example.android_mvvm_best_pratices.NO_INTERNET_CONNECTION_ERROR
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.data.error.NETWORK_ERROR
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator) : RemoteDataSource {
    lateinit var service: APIAuthService


    override suspend fun register(registerRequest: RegisterRequest): Resource<User> {
        service = serviceGenerator.createService(APIAuthService::class.java)
        return when (val response = processCall {
            service.register(
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

        return when (val response = processCall { service.login(loginRequest) }) {
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


    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {

        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful)
                response.body()
            else responseCode.toString() + ERROR_DELIMITER + response.errorBody()?.string()
        } catch (e: IOException) {
            NETWORK_ERROR

        }


    }


}


