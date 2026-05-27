package com.tkachenko.final_project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddMovieScreen(
    onBackClick: () -> Unit,
    onSaveMovie: (Movie) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var imageUrl by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Добавление фильма",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },

            label = {
                Text("Название")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },

            label = {
                Text("Описание")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = imageUrl,
            onValueChange = {
                imageUrl = it
            },

            label = {
                Text("Ссылка на фото")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                val movie = Movie(
                    title = title,
                    description = description,
                    imageUrl = imageUrl
                )

                onSaveMovie(movie)
            },

            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Назад")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddMovieScreen() {

    AddMovieScreen(
        onBackClick = {},
        onSaveMovie = {}
    )
}