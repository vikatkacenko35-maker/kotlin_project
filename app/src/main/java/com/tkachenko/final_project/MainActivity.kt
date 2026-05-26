package com.tkachenko.final_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel = remember {
                MovieViewModel()
            }

            var currentScreen by remember {
                mutableStateOf("home")
            }

            when (currentScreen) {

                "home" -> {
                    HomeScreen(
                        onAddMovieClick = {
                            currentScreen = "add"
                        },

                        onLibraryClick = {
                            currentScreen = "library"
                        }
                    )
                }

                "add" -> {
                    AddMovieScreen(
                        onBackClick = {
                            currentScreen = "home"
                        },

                        onSaveMovie = { movie ->
                            viewModel.addMovie(movie)
                            currentScreen = "home"
                        }
                    )
                }

                "library" -> {
                    LibraryScreen(
                        movies = viewModel.movieList,

                        onBackClick = {
                            currentScreen = "home"
                        }
                    )
                }
            }
        }
    }
}

showBackground = true
@Composable
fun PreviewMain() {

    HomeScreen(
        onAddMovieClick = {},
        onLibraryClick = {}
    )
}