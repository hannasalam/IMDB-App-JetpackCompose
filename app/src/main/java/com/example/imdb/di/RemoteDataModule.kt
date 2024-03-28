package com.example.imdb.di

import com.example.imdb.data.api.MovieAPI
import com.example.imdb.data.db.MovieDB
import com.example.imdb.data.repository.dataSouceImpl.MovieRemoteDataSourceImpl
import com.example.imdb.data.repository.dataSource.MovieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideMoviesRemoteDataSource(movieApi: MovieAPI, movieDB: MovieDB) : MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(movieApi,movieDB = movieDB)
}