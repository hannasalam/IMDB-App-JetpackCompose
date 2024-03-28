package com.example.imdb.presentation.ui

import android.annotation.SuppressLint
import android.util.Log
import android.widget.RatingBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.imdb.BuildConfig
import com.example.imdb.R
import com.example.imdb.presentation.viewmodel.ViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(navController: NavHostController, movieId: String, viewModel: ViewModel) {
    viewModel.getMovieDetails(movieID = movieId.toInt())
    val movie by viewModel.selectedMovie.collectAsState()
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = movie?.title ?:" ")
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
    }){
        Card(
            Modifier
                .padding(it)
                .fillMaxHeight()
                .fillMaxWidth()) {
            Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = BuildConfig.POSTER_URL + (movie?.backdropPath ?: ""),
                    contentDescription = "The delasign logo",
                    contentScale = ContentScale.FillWidth
                )

                movie?.title?.let { it1 -> Text(text = it1, textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineSmall, color = Color.White, modifier = Modifier.padding(10.dp)) }
                movie?.releaseDate?.let { it1->  Text(text = "Release Date: "+ it1,textAlign = TextAlign.Center)}
                movie?.rating?.let { it1->  Text(text = "Rating: "+ String.format("%.1f", it1.toFloat()),textAlign = TextAlign.Center)}

            }
            Column {
                Spacer(modifier = Modifier.height(23.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.weight(0.05f))
                    Text(text = stringResource(R.string.summary), style = MaterialTheme.typography.titleLarge,
                        color = Color.White, modifier = Modifier.padding(1.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Add to favorites")
                    }

                }
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = movie?.overview ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))
            }



        }
    }
}