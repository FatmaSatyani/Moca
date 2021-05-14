package com.fatmasatyani.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.vo.Resource

class DetailTvShowViewModel(private val listRepository: MovieCatalogueRepository) : ViewModel() {

    var tvShowId: Int = 0

    fun addFavorite (tvShow: TvShow) {
        listRepository.addFavoriteTvShow(tvShow)
    }

    fun removeFavorite(tvShow: TvShow) {
        listRepository.removeFavoriteTvShow(tvShow)
    }

    fun isFavorite(tvShow: TvShow): Boolean {
        return listRepository.isFavoriteTvShowById(tvShow)
    }

    fun setSelectedTvShow(): LiveData<Resource<TvShow>> {
        return listRepository.getTvShow(tvShowId)
    }
}