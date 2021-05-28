package com.fatmasatyani.core.domain.usecase

//import com.fatmasatyani.core.data.entity.FavoriteTvShowData
//import com.fatmasatyani.core.data.entity.TvShow
//import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
//import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MocaUseCase {

    fun getListMovie(): Flow<Resource<List<MovieModel>>>
//    fun getMovie(id: Int): Flow<Resource<MovieModel>>
    fun getAllFavoriteMovie(): Flow<List<FavoriteMovieModel>>
    fun addFavoriteMovie(movie:  MovieModel)
    fun removeFavoriteMovie(movie:  MovieModel)
    fun isFavoriteMovie(movie: MovieModel) : Boolean
//    fun isFavoriteMovieById(movie: MovieModel) : Boolean

//    fun getListTvShow(): Flow<Resource<List<TvShowModel>>>
////    fun getTvShow(id: Int): Flow<Resource<TvShow>>
//    fun getAllFavoriteTvShow(): Flow<List<FavoriteTvShowModel>>
//    fun addFavoriteTvShow(tvShow: FavoriteTvShowModel)
//    fun removeFavoriteTvShow(tvShow: FavoriteTvShowModel)
//    fun isFavoriteTvShow(tvShow: TvShowModel) : Boolean
////    fun isFavoriteTvShowById(tvShow: TvShowModel) : Boolean

}