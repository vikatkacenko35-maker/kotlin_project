package com.tkachenko.final_project

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    onAddMovieClick: () -> Unit,
    onLibraryClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Генератор идей",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onAddMovieClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Добавить фильм")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onLibraryClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Моя библиотека")
        }
    }
}

showBackground = true
@Composable
fun PreviewHomeScreen() {

    HomeScreen(
        onAddMovieClick = {},
        onLibraryClick = {}
    )
}