package com.example.imdb.data.repository.dataSource

import androidx.paging.PagingData
import com.example.imdb.domain.model.Movie
import com.example.imdb.domain.model.MovieList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieRemoteDataSource {
   fun getPopularMovies(): Flow<PagingData<Movie>>
}