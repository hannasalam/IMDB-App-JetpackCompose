package com.example.imdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.imdb.domain.model.Movie
import com.example.imdb.domain.model.MovieRemoteKeys

@Database(
    entities = [Movie::class, MovieRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDB : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieRemoteKeysDao(): MovieRemoteKeysDao

    abstract fun bookmarksDao(): BookmarksDao
}