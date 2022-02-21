package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.DataRepository
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.ui.component.base.AuthenticationBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val dataRepository: DataRepository) :
    AuthenticationBaseViewModel() {
    val loginRequest = LoginRequest()
    val loginStatus = MutableLiveData<Resource<LoginResponse>>()


    init {
        loginStatus.postValue(Resource.Idle(""))
    }

    fun doLogin() {
        attempted = true
        loginStatus.postValue(Resource.Loading())
        viewModelScope.launch {
            dataRepository.doLogin(loginRequest).collect {

                loginStatus.postValue(it)
            }


        }


    }

    override fun correctInputs(): String {
        if (!attempted)
            return ""


        if (loginRequest.password.length < 5)
            return "Password must be at least 5 characters long"
        if (loginRequest.username.length < 5)
            return "Username must be at least 5 characters long"
        return ""
    }


}
