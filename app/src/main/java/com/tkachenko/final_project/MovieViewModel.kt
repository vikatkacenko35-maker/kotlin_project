package com.tkachenko.final_project

import androidx.compose.runtime.mutableStateListOf

class MovieViewModel {

    val movieList = mutableStateListOf<Movie>()

    fun addMovie(movie: Movie) {
        movieList.add(movie)
    }

    fun getRandomMovie(): Movie? {
        if (movieList.isEmpty()) return null
        return movieList.random()
    }
}