package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse


interface ListDataSource {

    fun getListMovies (page: Int) : LiveData<List<Movie>>

    fun getMovie (id: Int) : LiveData<Movie>

    fun getListTvShows (page: Int) : LiveData<List<TvShow>>

    fun getTvShow(id: Int) : LiveData<TvShow>
}