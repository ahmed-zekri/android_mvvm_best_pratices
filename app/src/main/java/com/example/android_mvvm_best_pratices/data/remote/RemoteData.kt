package com.example.android_mvvm_best_pratices.data.remote

import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest
import com.example.android_mvvm_best_pratices.data.error.NETWORK_ERROR
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator) : RemoteDataSource {
    override suspend fun register(registerRequest: RegisterRequest): Any? {
        val service = serviceGenerator.createService(APIService::class.java)
        return processCall {
            service.register(
                registerRequest.email,
                registerRequest.password,
                registerRequest.role
            )
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


