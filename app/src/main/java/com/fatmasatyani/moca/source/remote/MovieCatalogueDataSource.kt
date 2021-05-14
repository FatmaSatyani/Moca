package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.FavoriteTvShowData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.vo.Resource

interface MovieCatalogueDataSource {

    fun getListMovies (page: Int) : LiveData<Resource<PagedList<Movie>>>

    fun getMovie (id: Int) : LiveData<Resource<Movie>>

    fun getAllFavoriteMovies(): LiveData<PagedList<FavoriteMovieData>>

    fun addFavoriteMovie(movie: Movie)

    fun removeFavoriteMovie(movie: Movie)

    fun isFavoriteMovie(movie: Movie): Boolean


    fun getListTvShows (page: Int) : LiveData<Resource<PagedList<TvShow>>>

    fun getTvShow(id: Int) : LiveData<Resource<TvShow>>

    fun getAllFavoriteTvShow(): LiveData<PagedList<FavoriteTvShowData>>

    fun addFavoriteTvShow (tvShow: TvShow)

    fun removeFavoriteTvShow (tvShow: TvShow)

    fun isFavoriteTvShow (tvShow: TvShow) : Boolean
}