package com.example.imdb.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Shapes
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.example.imdb.BuildConfig
import com.example.imdb.domain.model.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListItem(movie: Movie, onclick: ()->Unit) {
    Card(shape = RoundedCornerShape(0.dp),
        modifier = Modifier.padding(1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        onClick = onclick
        ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = movie.title?:" ", modifier = Modifier.padding(6.dp), maxLines = 1,overflow = TextOverflow.Ellipsis)
            movie.posterPath?.let {
                AsyncImage(
                    model = BuildConfig.POSTER_URL + movie.posterPath,
                    contentDescription = "The delasign logo",
                )

            }
        }

    }


}

