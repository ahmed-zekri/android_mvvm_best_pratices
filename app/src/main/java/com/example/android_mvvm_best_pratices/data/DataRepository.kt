package com.example.android_mvvm_best_pratices.data

import com.example.android_mvvm_best_pratices.data.remote.RemoteData
import javax.inject.Inject

class DataRepository @Inject constructor(private val remoteRepository:RemoteData) {
}