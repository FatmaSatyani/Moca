package com.fatmasatyani.moca.movie

import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.MovieEntity
import com.fatmasatyani.moca.utils.Data

class MovieViewModel: ViewModel() {

    val movies: List<MovieEntity> = Data.generateMovie()
    fun getMovies(id: String): MovieEntity? = Data.movieDetails(id)

}