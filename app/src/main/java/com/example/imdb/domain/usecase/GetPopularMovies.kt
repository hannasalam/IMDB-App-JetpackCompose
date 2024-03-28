package com.example.imdb.domain.usecase

import com.example.imdb.domain.repository.MovieRepository

class GetPopularMovies(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getPopularMovies()
}