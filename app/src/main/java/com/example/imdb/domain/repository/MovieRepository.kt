package com.example.imdb.domain.repository

import com.example.imdb.domain.model.MovieList
import com.example.imdb.domain.utils.Result

interface MovieRepository {
    suspend fun getPopularMovies(): Result<MovieList>
}