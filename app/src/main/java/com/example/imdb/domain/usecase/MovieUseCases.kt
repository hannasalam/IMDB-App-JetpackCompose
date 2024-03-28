package com.example.imdb.domain.usecase

data class MovieUseCases(
    val getPopularMoviesUseCase: GetPopularMovies,
    val getMoviesFromDBUseCase: GetMoviesFromDBUseCase,
)
