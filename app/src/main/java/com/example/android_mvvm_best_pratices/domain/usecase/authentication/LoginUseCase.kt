package com.example.android_mvvm_best_pratices.domain.usecase.authentication

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.domain.repositories.user.DataRepositoryUserSource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val dataRepositoryUserSource: DataRepositoryUserSource) {
    operator fun invoke(loginRequest: LoginRequest) = flow {
        try {
            if (loginRequest.password.length < 5) {
                emit(Resource.Error(message = "Password must be at least 5 characters long"))

                return@flow
            }
            if (loginRequest.username.length < 5) {
                emit(Resource.Error(message = "Username must be at least 5 characters long"))
                return@flow
            }
            emit(Resource.Loading())
            val response = dataRepositoryUserSource.doLogin(loginRequest)
            if (response.isSuccessful)
                when (response.body()) {
                    is LoginResponse -> emit(Resource.Success(response.body()!!))


                }
            else
                emit(Resource.Error(message = response.errorBody()?.string()))


        } catch (e: IOException) {
            emit(Resource.Error(message = SERVER_ERROR))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: ERROR_OCCURRED))

        }
    }

}