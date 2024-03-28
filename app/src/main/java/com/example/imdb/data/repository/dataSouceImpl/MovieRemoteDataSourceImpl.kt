package com.example.imdb.data.repository.dataSouceImpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.imdb.BuildConfig
import com.example.imdb.data.api.MovieAPI
import com.example.imdb.data.db.MovieDB
import com.example.imdb.data.paging.MovieRemoteMediator
import com.example.imdb.data.repository.dataSource.MovieRemoteDataSource
import com.example.imdb.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieRemoteDataSourceImpl(private val movieApi: MovieAPI, private val movieDB: MovieDB) :
    MovieRemoteDataSource {
    private val movieDao = movieDB.movieDao()


    @OptIn(ExperimentalPagingApi::class)
    override  fun getPopularMovies() : Flow<PagingData<Movie>> {
        val pagingSourceFactory = { movieDao.getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MovieRemoteMediator(
                movieApi,
                movieDB
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}