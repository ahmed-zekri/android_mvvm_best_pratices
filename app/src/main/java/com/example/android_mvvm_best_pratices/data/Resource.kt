package com.example.android_mvvm_best_pratices.data

import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel

// A generic class that contains data and status about loading this data.
sealed class Resource<T> constructor(
    val data: T? = null,
    val errorCode: Int? = null
)  {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class DataError<T>(errorCode: Int) : Resource<T>(null, errorCode)


}