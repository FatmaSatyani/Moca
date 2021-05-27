package com.fatmasatyani.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fatmasatyani.core.domain.usecase.MocaUseCase

class FavoriteMovieViewModel(private val mocaUseCase: MocaUseCase): ViewModel() {

    val favoriteMovie = mocaUseCase.getAllFavoriteMovie().asLiveData()

}