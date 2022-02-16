package com.example.android_mvvm_best_pratices.data.remote

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.data.error.NETWORK_ERROR
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator) : RemoteDataSource {
    override suspend fun register(registerRequest: RegisterRequest): Resource<User> {
        val service = serviceGenerator.createService(APIAuthService::class.java)
        return when (val response = processCall {
            service.register(
                registerRequest
            )
        }) {
            is User -> Resource.Success(data = response)
            else -> Resource.DataError(errorCode = response as Int)
        }


    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {

        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful)
                response.body()
            else responseCode
        } catch (e: IOException) {
            NETWORK_ERROR

        }


    }


}


