package com.example.android_mvvm_best_pratices.domain.usecase.authentication

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.error.ERROR_OCCURRED
import com.example.android_mvvm_best_pratices.data.error.SERVER_ERROR
import com.example.android_mvvm_best_pratices.data.repositories.user.DataRepositoryUserImpl
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(val dataRepositoryUserImpl: DataRepositoryUserImpl)

operator fun LoginUseCase.invoke(loginRequest: LoginRequest?) = flow {
    try {
        emit(Resource.Loading())

        emit(Resource.Success(dataRepositoryUserImpl.doLogin(loginRequest)))
    } catch (e: IOException) {
        emit(Resource.Error(message = SERVER_ERROR))
    } catch (e: HttpException) {
        emit(Resource.Error(message = e.localizedMessage ?: ERROR_OCCURRED))

    }


}