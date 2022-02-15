package com.example.android_mvvm_best_pratices.usecase.errors

import com.example.android_mvvm_best_pratices.data.error.mapper.ErrorMapper
import javax.inject.Inject
import com.example.android_mvvm_best_pratices.data.error.Error

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}
