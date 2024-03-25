package com.example.imdb.data.repository.dataSouceImpl

import com.example.imdb.BuildConfig
import com.example.imdb.data.api.MovieAPI
import com.example.imdb.data.repository.dataSource.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(private val movieApi: MovieAPI): MovieRemoteDataSource {
    override suspend fun getPopularMovies()= movieApi.getPopularMovies(BuildConfig.API_KEY)

}