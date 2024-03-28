package com.example.imdb.di


import com.example.imdb.data.db.MovieDao
import com.example.imdb.data.repository.dataSouceImpl.MovieLocalDataSourceImpl
import com.example.imdb.data.repository.dataSource.MovieLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao = movieDao)
}