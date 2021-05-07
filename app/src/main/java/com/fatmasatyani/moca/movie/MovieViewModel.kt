package com.fatmasatyani.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.ListRepository

class MovieViewModel(private val listRepository: ListRepository) : ViewModel() {

    var page = 1

    fun getMovie(): LiveData<List<Movie>> {
        return listRepository.getListMovies(page)
    }
}
