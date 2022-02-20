package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.register

import android.widget.CompoundButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.DataRepository
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val dataRepository: DataRepository) :
    BaseViewModel() {

    private var attempted = false
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

    fun correctInputs(): Boolean {
        if (!attempted)
            return true

        return registerRequest.email.isNotEmpty() && registerRequest.password.isNotEmpty() && registerRequest.username.isNotEmpty()

    }

    fun doRegister() {
        attempted = true
        registerStatus.postValue(Resource.Loading())
        if (!correctInputs()) {
            registerStatus.postValue(Resource.Idle())
            return
        }

        viewModelScope.launch {
            dataRepository.doRegister(registerRequest).collect {

                registerStatus.postValue(it)
            }


        }


    }


}
