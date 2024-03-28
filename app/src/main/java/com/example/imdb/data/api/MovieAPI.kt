package com.example.imdb.data.api

import com.example.imdb.domain.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        )apiKey:String,
        @Query("page") page: Int = 1,
    ): Response<MovieList>
}