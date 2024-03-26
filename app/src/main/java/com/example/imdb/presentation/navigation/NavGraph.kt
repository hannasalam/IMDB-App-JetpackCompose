package com.example.imdb.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.imdb.presentation.ui.HomeScreen
import androidx.navigation.NavType
import com.example.imdb.presentation.ui.MovieDetailsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.MovieDetails.route,
            arguments = listOf(navArgument("movieId") {
                type = NavType.StringType
            })) {

            it.arguments?.getString("movieId")
                ?.let { it1 -> MovieDetailsScreen(navController = navController, movieId = it1) }
        }
    }
}