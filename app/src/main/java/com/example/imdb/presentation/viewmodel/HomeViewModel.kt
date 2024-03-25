package com.example.imdb.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb.domain.model.MovieList
import com.example.imdb.domain.usecase.GetPopularMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.imdb.domain.utils.Result
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMovies
):ViewModel(){
    private val _movieState = mutableStateOf<Result<MovieList>>(Result.Loading())
    val movieState: State<Result<MovieList>> = _movieState
    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            _movieState.value =  getPopularMoviesUseCase()
        }
    }

}