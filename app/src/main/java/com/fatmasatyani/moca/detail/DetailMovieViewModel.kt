package com.fatmasatyani.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.ListRepository

class DetailMovieViewModel(private val listRepository: ListRepository) : ViewModel() {

    var movieId: Int = 0

    fun setSelectedMovie(): LiveData<Movie> {
        return listRepository.getMovie(movieId)
    }
}
