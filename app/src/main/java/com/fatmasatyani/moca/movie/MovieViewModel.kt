package com.fatmasatyani.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.ListRepository

class MovieViewModel(private val listRepository: ListRepository) : ViewModel() {

//    val movies: List<MovieEntity> = Data.generateMovie()
//    fun getMovies(id: String): MovieEntity? = Data.movieDetails(id)
//    fun getMovies(): Any {
//
//    }
    var page = 1

    fun getMovie(): LiveData<List<Movie>> {
        return listRepository.getListMovies(page)
    }

}