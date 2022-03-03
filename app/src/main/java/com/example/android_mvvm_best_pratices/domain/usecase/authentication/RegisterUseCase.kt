package com.example.android_mvvm_best_pratices.domain.usecase.authentication

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.error.ERROR_OCCURRED
import com.example.android_mvvm_best_pratices.data.error.SERVER_ERROR
import com.example.android_mvvm_best_pratices.data.remote.authentication.APIAuthService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

open class RegisterUseCase @Inject constructor(val apiAuthService: APIAuthService) {
    operator fun RegisterUseCase.invoke(registerRequest: RegisterRequest) = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(apiAuthService.register(registerRequest)))
        } catch (e: IOException) {
            emit(Resource.Error(message = SERVER_ERROR))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: ERROR_OCCURRED))

        }


    }

    open fun a() {}
}
class b : RegisterUseCase() {
    override fun a(){}


}


