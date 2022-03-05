package com.example.android_mvvm_best_pratices.domain.usecase.authentication

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.domain.model.user.User
import com.example.android_mvvm_best_pratices.domain.repositories.user.DataRepositoryUserSource
import com.example.android_mvvm_best_pratices.utils.RegexUtils
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val dataRepositoryUserSource: DataRepositoryUserSource) {
    operator fun invoke(registerRequest: RegisterRequest) = flow {
        try {
            if (!RegexUtils.isValidEmail(registerRequest.email)) {
                emit(Resource.Error(message = "Invalid mail"))
                return@flow
            }


            if (registerRequest.password.length < 5) {
                emit(Resource.Error(message = "Password must be at least 5 characters long"))
                return@flow

            }
            if (registerRequest.username.length < 5) {
                emit(Resource.Error(message = "Username must be at least 5 characters long"))
                return@flow
            }
            emit(Resource.Loading())
            val response = dataRepositoryUserSource.doRegister(registerRequest)
            if (response.isSuccessful)
                when (response.body()) {
                    is User -> emit(Resource.Success(response.body()!!))


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



