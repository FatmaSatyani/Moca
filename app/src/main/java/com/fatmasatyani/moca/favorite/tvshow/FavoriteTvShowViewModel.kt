package com.fatmasatyani.moca.favorite.tvshow

import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository

class FavoriteTvShowViewModel(private val repository: MovieCatalogueRepository): ViewModel() {

    fun getFavTvShow() = repository.getAllFavoriteTvShow()

}