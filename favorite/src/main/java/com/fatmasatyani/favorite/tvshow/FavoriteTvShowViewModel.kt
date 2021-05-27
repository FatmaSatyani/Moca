package com.fatmasatyani.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fatmasatyani.core.domain.usecase.MocaUseCase

class FavoriteTvShowViewModel(private val mocaUseCase: MocaUseCase): ViewModel() {

    val favoriteTvShow = mocaUseCase.getAllFavoriteTvShow().asLiveData()

}