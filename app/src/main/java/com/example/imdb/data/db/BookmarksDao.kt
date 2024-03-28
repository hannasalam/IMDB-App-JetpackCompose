package com.example.imdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imdb.domain.model.BookmarkedMovie
import retrofit2.Response

@Dao
interface BookmarksDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addBookmark(bookmarkedMovie: BookmarkedMovie)
//
//    @Query("SELECT * FROM bookmarked_movies")
//    suspend fun getBookmarkedMovies(): Response<BookmarkedMovie>
//    @Query("DELETE FROM bookmarked_movies WHERE movieId = :movieId")
//    suspend fun deleteOneBookmarked(movieId: Int)
}