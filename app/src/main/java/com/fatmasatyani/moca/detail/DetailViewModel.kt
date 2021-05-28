package com.fatmasatyani.moca.detail

import androidx.lifecycle.ViewModel
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.domain.usecase.MocaUseCase
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.flow.Flow

class DetailViewModel(private val mocaUseCase: MocaUseCase) : ViewModel() {

    fun addFavorite (movie: MovieModel) {
        mocaUseCase.addFavoriteMovie(movie)
    }

    fun removeFavorite(movie: MovieModel) {
        mocaUseCase.removeFavoriteMovie(movie)
    }

    fun isFavorite(movie: MovieModel): Boolean {
        return mocaUseCase.isFavoriteMovie(movie)
    }

    fun setSelectedMovie(): Flow<Resource<List<MovieModel>>> {
        return mocaUseCase.getListMovie()
    }
}
