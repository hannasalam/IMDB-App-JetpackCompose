package com.example.imdb.data.repository

import android.util.Log
import com.example.imdb.data.repository.dataSource.MovieLocalDataSource
import com.example.imdb.data.repository.dataSource.MovieRemoteDataSource
import com.example.imdb.domain.model.Movie
import com.example.imdb.domain.model.MovieList
import com.example.imdb.domain.repository.MovieRepository
import com.example.imdb.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) :
    MovieRepository {
    override fun getPopularMovies() =
        movieRemoteDataSource.getPopularMovies()

    override fun getMoviesFromDB(movieId: Int): Flow<Movie> =
        movieLocalDataSource.getMoviesFromDB(movieId)
}