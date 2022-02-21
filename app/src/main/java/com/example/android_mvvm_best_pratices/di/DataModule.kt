package com.example.android_mvvm_best_pratices.di

import com.example.android_mvvm_best_pratices.data.repositories.user.DataRepositoryUserSource
import com.example.android_mvvm_best_pratices.data.remote.authentication.RemoteDataSourceAuthentication
import com.example.android_mvvm_best_pratices.data.remote.movies.RemoteDataSourceMovies
import com.example.android_mvvm_best_pratices.data.repositories.movie.DataRepositoryMovieSource
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
    abstract fun provideRemoteDataAuthentication(remoteDataSourceAuthentication: RemoteDataSourceAuthentication): RemoteDataSourceAuthentication

    @Binds
    @Singleton
    abstract fun provideRemoteRepositoryAuthentication(dataRepositoryUserSource: DataRepositoryUserSource): DataRepositoryUserSource


    @Binds
    @Singleton
    abstract fun provideRemoteDataMovies(remoteDataSourceMovies: RemoteDataSourceMovies): RemoteDataSourceMovies

    @Binds
    @Singleton
    abstract fun provideRemoteRepositoryMovies(dataRepositoryMovieSource: DataRepositoryMovieSource): DataRepositoryMovieSource


}