package com.example.imdb.data.repository.dataSouceImpl

import com.example.imdb.data.db.MovieDao
import com.example.imdb.data.repository.dataSource.MovieLocalDataSource
import com.example.imdb.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override fun getMoviesFromDB(movieId: Int): Flow<Movie> = movieDao.getMovie(movieId)
}