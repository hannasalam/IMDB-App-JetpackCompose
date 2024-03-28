package com.example.imdb.domain.model

import androidx.room.Entity

@Entity(tableName = "bookmarked_movies")
data class BookmarkedMovie(
    val movieId: Int
)