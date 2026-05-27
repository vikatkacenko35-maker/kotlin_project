package com.tkachenko.final_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LibraryScreen(
    movies: List<Movie>,
    onBackClick: () -> Unit
) {

    var randomMovie by remember {
        mutableStateOf<Movie?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Моя библиотека",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (movies.isEmpty()) {

            Text("Библиотека пока пуста")

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(movies) { movie ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {

                            Image(
                                painter = rememberAsyncImagePainter(movie.imageUrl),
                                contentDescription = null,

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),

                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = movie.title,
                                style = MaterialTheme.typography.titleLarge
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(movie.description)
                        }
                    }
                }
            }

            Button(
                onClick = {
                    randomMovie = movies.random()
                },

                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Рандомайзер")
            }

            Spacer(modifier = Modifier.height(10.dp))

            randomMovie?.let {

                Text(
                    text = "Сегодня смотри: ${it.title}",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("На главную")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewLibraryScreen() {

    val testMovies = listOf(
        Movie(
            "Интерстеллар",
            "Фильм про космос",
            "https://i.imgur.com/tGbaZCY.jpg"
        )
    )

    LibraryScreen(
        movies = testMovies,
        onBackClick = {}
    )
}