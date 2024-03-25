package com.example.imdb.data.repository.dataSource

import com.example.imdb.domain.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(): Response<MovieList>
}