package com.example.imdb.di

import com.example.imdb.data.repository.MovieRepositoryImpl
import com.example.imdb.data.repository.dataSource.MovieRemoteDataSource
import com.example.imdb.data.repository.dataSource.MovieLocalDataSource
import com.example.imdb.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMoviesRepository(movieRemoteDataSource: MovieRemoteDataSource,
                                movieLocalDataSource: MovieLocalDataSource) : MovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource = movieLocalDataSource)
}