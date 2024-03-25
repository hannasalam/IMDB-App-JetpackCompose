package com.example.imdb.di

import com.example.imdb.domain.repository.MovieRepository
import com.example.imdb.domain.usecase.GetPopularMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository) =
        GetPopularMovies(movieRepository)
}