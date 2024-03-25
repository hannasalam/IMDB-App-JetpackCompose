package com.example.imdb.data.repository

import android.util.Log
import com.example.imdb.data.repository.dataSource.MovieRemoteDataSource
import com.example.imdb.domain.model.MovieList
import com.example.imdb.domain.repository.MovieRepository
import com.example.imdb.domain.utils.Result
import retrofit2.Response

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource) : MovieRepository {
    override suspend fun getPopularMovies(): Result<MovieList> {
        return responseToRequest(movieRemoteDataSource.getPopularMovies())
    }
    private fun responseToRequest(response: Response<MovieList>):Result<MovieList>{
        Log.d("Reached Impl", response.isSuccessful.toString())
        if(response.isSuccessful){
            response.body()?.let {result->
                return Result.Success(result)
            }
        }
        return Result.Error(response.message())
    }
}