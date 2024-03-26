package com.example.imdb.presentation.ui
import android.annotation.SuppressLint
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.imdb.R
import com.example.imdb.domain.model.Movie
import com.example.imdb.domain.utils.Result
import com.example.imdb.presentation.components.MovieListItem
import com.example.imdb.presentation.navigation.Screen
import com.example.imdb.presentation.viewmodel.HomeViewModel
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()){
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name), color = Color.Yellow)
            },
        )
    }) {
        when (val movieResponse = viewModel.movieState.value) {
            is Result.Loading -> {
//                CircularProgressIndicator()
            }
            is Result.Success ->
                movieResponse.data?.let {movieList->
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(150.dp),

                        // content padding
                        contentPadding = it,
                        content = {
                            items(movieList.movies){
                                MovieListItem(movie = it,
                                    { navController.navigate(route = Screen.MovieDetails.passMovieId(it.id.toString())) })
                            }
                        })
                }


            is Result.Error -> Toast.makeText(
                LocalContext.current,
                stringResource(R.string.toast_error),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

