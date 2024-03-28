package com.example.imdb.presentation.ui
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.imdb.R
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.imdb.domain.utils.Result
import com.example.imdb.presentation.components.MovieListItem
import com.example.imdb.presentation.navigation.Screen
import com.example.imdb.presentation.viewmodel.ViewModel
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: ViewModel = hiltViewModel()){
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name), color = Color.Yellow)
            },
        )
    }) {
        val allMovies = remember {
            viewModel.getAllPopularMovies
        }.collectAsLazyPagingItems()

        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),

                        // content padding
            contentPadding = it
        ) {
            items(count = allMovies.itemCount) { index ->
                val movie = allMovies[index]
                if (movie != null) {
                    MovieListItem(
                        movie = movie,
                        { navController.navigate(route = Screen.MovieDetails.passMovieId(movie.movieId.toString())) })
                }
            }
        }
    }
}

//MovieListItem(movie = movie,
//{ navController.navigate(route = Screen.MovieDetails.passMovieId(movie.id.toString())) }