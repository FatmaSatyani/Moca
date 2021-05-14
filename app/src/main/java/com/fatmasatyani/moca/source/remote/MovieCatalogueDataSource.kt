package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.vo.Resource

interface MovieCatalogueDataSource {

    fun getListMovies (page: Int) : LiveData<Resource<List<Movie>>>

    fun getMovie (id: Int) : LiveData<Resource<Movie>>

    fun getListTvShows (page: Int) : LiveData<List<TvShow>>

    fun getTvShow(id: Int) : LiveData<TvShow>

    fun getAllFavoriteMovies(): LiveData<PagedList<Movie>>

    fun addFavoriteMovie(movie: Movie)

    fun removeFavoriteMovie(movie: Movie)

    fun isFavoriteMovie(movie: Movie): Boolean

    fun getAllFavoriteTvShow(): LiveData<PagedList<TvShow>>

    fun addFavoriteTvShow (tvShow: TvShow)

    fun removeFavoriteTvShow (tvShow: TvShow)

    fun isFavoriteTvShow (tvShow: TvShow) : Boolean
}