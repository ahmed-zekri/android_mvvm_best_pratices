package com.example.android_mvvm_best_pratices.ui.component.base
import com.example.android_mvvm_best_pratices.ERROR_DELIMITER
import com.example.android_mvvm_best_pratices.data.error.NETWORK_ERROR
import com.example.android_mvvm_best_pratices.data.remote.movies.APIMoviesService
import com.example.android_mvvm_best_pratices.data.remote.ServiceGenerator
import com.example.android_mvvm_best_pratices.data.remote.authentication.APIAuthService
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException

open class BaseRemoteData constructor(serviceGenerator: ServiceGenerator) {
    var authService = serviceGenerator.createService(APIAuthService::class.java)
    var movieService = serviceGenerator.createService(APIMoviesService::class.java)

    suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {

        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful)
                response.body()
            else responseCode.toString() + ERROR_DELIMITER + getErrorBody(response.errorBody())
        } catch (e: IOException) {
            NETWORK_ERROR

        }


    }

    private fun getErrorBody(errorBody: ResponseBody?) = errorBody?.string()

}