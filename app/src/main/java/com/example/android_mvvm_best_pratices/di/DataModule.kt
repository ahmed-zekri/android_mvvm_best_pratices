package com.example.android_mvvm_best_pratices.di

import com.example.android_mvvm_best_pratices.data.DataRepositorySource
import com.example.android_mvvm_best_pratices.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideRemoteData(remoteDataSource: RemoteDataSource): RemoteDataSource

    @Binds
    @Singleton
    abstract fun provideRemoteRepository(dataRepositorySource: DataRepositorySource): DataRepositorySource


}