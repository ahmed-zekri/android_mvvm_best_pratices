package com.example.android_mvvm_best_pratices.ui.component.base

import androidx.lifecycle.ViewModel
import com.example.android_mvvm_best_pratices.usecase.errors.ErrorManager
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    lateinit var errorManager: ErrorManager
}