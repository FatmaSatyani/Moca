package com.fatmasatyani.moca.detail

import androidx.lifecycle.ViewModel
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.core.domain.usecase.MocaUseCase
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.flow.Flow

class DetailTvShowViewModel(private val mocaUseCase: MocaUseCase) : ViewModel() {

    fun addFavorite (tvShow: FavoriteTvShowModel) {
        mocaUseCase.addFavoriteTvShow(tvShow)
    }

    fun removeFavorite(tvShow: FavoriteTvShowModel) {
        mocaUseCase.removeFavoriteTvShow(tvShow)
    }

    fun isFavorite(tvShow: TvShowModel): Boolean {
        return mocaUseCase.isFavoriteTvShow(tvShow)
    }

    fun setSelectedTvShow(): Flow<Resource<List<TvShowModel>>> {
        return mocaUseCase.getListTvShow()
    }
}