package com.example.android_mvvm_best_pratices.usecase.errors

import com.example.android_mvvm_best_pratices.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int): Error

}
