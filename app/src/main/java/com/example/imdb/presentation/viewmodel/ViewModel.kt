package com.example.imdb.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb.domain.model.Movie
import com.example.imdb.domain.usecase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases
) : ViewModel() {
    private val _selectedMovie: MutableStateFlow<Movie?> = MutableStateFlow(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    fun getMovieDetails(movieID: Int) {
        viewModelScope.launch {
            movieUseCases.getMoviesFromDBUseCase.invoke(movieID = movieID).collect {
                _selectedMovie.value = it
            }
        }
    }
    val getAllPopularMovies = movieUseCases.getPopularMoviesUseCase()
}