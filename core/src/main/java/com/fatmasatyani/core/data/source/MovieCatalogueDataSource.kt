package com.fatmasatyani.core.data.source

import androidx.lifecycle.LiveData
import com.fatmasatyani.core.data.entity.FavoriteMovieData
import com.fatmasatyani.core.data.entity.FavoriteTvShowData
import com.fatmasatyani.core.data.entity.Movie
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.utils.Resource

interface MovieCatalogueDataSource {

//    fun getListMovies (page: Int) : LiveData<Resource<PagedList<Movie>>>
//
//    fun getMovie (id: Int) : LiveData<Resource<Movie>>
//
//    fun getAllFavoriteMovies(): LiveData<PagedList<FavoriteMovieData>>
//
//    fun addFavoriteMovie(movie: Movie)
//
//    fun removeFavoriteMovie(movie: Movie)
//
//    fun isFavoriteMovie(movie: Movie): Boolean
//
//    fun isFavoriteMovieById (movie: Movie) : Boolean
//
//    fun getListTvShows (page: Int) : LiveData<Resource<PagedList<TvShow>>>
//
//    fun getTvShow(id: Int) : LiveData<Resource<TvShow>>
//
//    fun getAllFavoriteTvShow(): LiveData<PagedList<FavoriteTvShowData>>
//
//    fun addFavoriteTvShow (tvShow: TvShow)
//
//    fun removeFavoriteTvShow (tvShow: TvShow)
//
//    fun isFavoriteTvShow (tvShow: TvShow) : Boolean
//
//    fun isFavoriteTvShowById (tvShow: TvShow): Boolean
}