package com.fatmasatyani.moca.favorite.movie

import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository

class FavoriteMovieViewModel (private val repository: MovieCatalogueRepository): ViewModel() {

    fun getFavMovie() = repository.getAllFavoriteMovies()

}