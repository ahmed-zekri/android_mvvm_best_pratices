package com.example.android_mvvm_best_pratices.ui.component.base

abstract class AuthenticationBaseViewModel : BaseViewModel() {
     var attempted = false
    abstract fun correctInputs():String
}