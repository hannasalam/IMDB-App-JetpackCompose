package com.example.imdb.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imdb.data.repository.MovieRepositoryImpl
import com.example.imdb.data.repository.dataSouceImpl.MovieRemoteDataSourceImpl
import com.example.imdb.presentation.ui.theme.IMDBTheme
import com.example.imdb.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imdb.domain.utils.Result
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val api = RemoteDataSouceInjector.ApiContainer
//        val c = api.getInstance()
//        val k = MovieRemoteDataSourceImpl(c)
//        val r = MovieRepositoryImpl(k)

//        GlobalScope.launch {
//            val d= r.getPopularMovies()
//            Log.d("Fetched API", d.toString())
//        }
        setContent {
            IMDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: HomeViewModel = hiltViewModel()) {
    when (val movieResponse = viewModel.movieState.value) {
//        is Result.Loading -> ProgressBar()
        is Result.Success -> Log.d("Got movies", movieResponse.data.toString())
//        is Result.Error -> Toast.makeText(
//            Lxfre4szocalContext.current,
//            stringResource(R.string.toast_error),
//            Toast.LENGTH_SHORT
//        )
        is Result.Error -> {
        }
        is Result.Loading -> {

        }
        else -> {}
    }
}
