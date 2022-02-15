package com.example.android_mvvm_best_pratices.ui.component.login

import com.example.android_mvvm_best_pratices.data.DataRepository
import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val dataRepository: DataRepository) :
    BaseViewModel() {
suspend fun doLogin(registerRequest: RegisterRequest){


    dataRepository.doRegister(registerRequest)

}
}