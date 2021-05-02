package com.fatmasatyani.moca.detail

import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.MovieEntity
import com.fatmasatyani.moca.data.TvShowEntity
import com.fatmasatyani.moca.utils.Data

class DetailViewModel: ViewModel() {

     private lateinit var movieId: String
     private lateinit var tvShowId: String

     fun setSelectedMovie(movieId: String) {
         this.movieId = movieId
     }
    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getMovie(movieId: String):  MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = Data.generateMovie()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTvShow(tvShowId: String): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowEntities = Data.generateTvShow()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}