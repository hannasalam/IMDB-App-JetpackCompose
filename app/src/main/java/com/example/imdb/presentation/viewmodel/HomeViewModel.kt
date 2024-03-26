package com.example.imdb.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb.domain.model.Movie
import com.example.imdb.domain.model.MovieList
import com.example.imdb.domain.usecase.GetPopularMovies
import com.example.imdb.domain.usecase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.imdb.domain.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMovies,
//    private val movieUseCases: MovieUseCases
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

//    private val _selectedMovie: MutableStateFlow<Movie?> = MutableStateFlow(null)
//    val selectedMovie: StateFlow<Movie?> = _selectedMovie
//
//    fun getMovieDetails(movieID: Int) {
//        viewModelScope.launch {
//            movieUseCases.getMoviesFromDBUseCase.invoke(movieID = movieID).collect {
//                _selectedMovie.value = it
//            }
//        }
//    }

}