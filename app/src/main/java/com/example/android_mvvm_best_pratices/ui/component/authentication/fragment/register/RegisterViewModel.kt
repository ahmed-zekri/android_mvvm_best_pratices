package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.register

import android.widget.CompoundButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.repositories.user.DataRepositoryUserUserImpl
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.ui.component.base.AuthenticationBaseViewModel
import com.example.android_mvvm_best_pratices.utils.RegexUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val dataRepositoryUserImpl: DataRepositoryUserUserImpl) :
    AuthenticationBaseViewModel() {


    val registerRequest = RegisterRequest()
    val registerStatus = MutableLiveData<Resource<User>>()


    val checkBoxCheckedStateListener =
        CompoundButton.OnCheckedChangeListener { p0, p1 ->

            if (p1)

                registerRequest.roles += p0.text.toString()
            else if (registerRequest.roles.contains(p0.text.toString()))
                registerRequest.roles -= p0.text.toString()
        }


    init {
        registerStatus.postValue(Resource.Idle())

    }

    override fun correctInputs(): String {

        if (!attempted)
            return ""
        if (!RegexUtils.isValidEmail(registerRequest.email))
            return "Invalid mail"

        if (registerRequest.password.length < 5)
            return "Password must be at least 5 characters long"
        if (registerRequest.username.length < 5)
            return "Username must be at least 5 characters long"
        return ""
    }

    fun doRegister() {
        attempted = true
        registerStatus.postValue(Resource.Loading())
        if (correctInputs() != "") {
            registerStatus.postValue(Resource.Idle())
            return
        }

        viewModelScope.launch {
            dataRepositoryUserImpl.doRegister(registerRequest).collect {

                registerStatus.postValue(it)
            }


        }


    }


}
