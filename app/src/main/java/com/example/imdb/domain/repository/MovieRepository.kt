package com.example.imdb.domain.repository

import androidx.paging.PagingData
import com.example.imdb.domain.model.BookmarkedMovie
import com.example.imdb.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<PagingData<Movie>>
    fun getMoviesFromDB(movieId: Int): Flow<Movie>

//    fun getBookmarkedMovies(): Flow<BookmarkedMovie>
//
//    suspend fun deleteBookmarkedMovie(movieId: Int)
//    suspend fun addBookmarkMovie(bookmarkedMovie: BookmarkedMovie)

}