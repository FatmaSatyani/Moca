package com.fatmasatyani.core.domain.repository

import com.fatmasatyani.core.domain.model.FavoriteMovieModel
//import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
import com.fatmasatyani.core.domain.model.MovieModel
//import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IMocaRepository {

    fun getListMovie(): Flow<Resource<List<MovieModel>>>
    fun getAllFavoriteMovie(): Flow<List<FavoriteMovieModel>>
    fun addFavoriteMovie(movie: MovieModel)
    fun removeFavoriteMovie(movie: MovieModel)
    fun isFavoriteMovie(movie: MovieModel) : Boolean

//    fun getListTvShow(): Flow<Resource<List<TvShowModel>>>
//    fun getAllFavoriteTvShow(): Flow<List<FavoriteTvShowModel>>
//    fun addFavoriteTvShow(tvShow: FavoriteTvShowModel)
//    fun removeFavoriteTvShow(tvShow: FavoriteTvShowModel)
//    fun isFavoriteTvShow(tvShow: TvShowModel) : Boolean
}