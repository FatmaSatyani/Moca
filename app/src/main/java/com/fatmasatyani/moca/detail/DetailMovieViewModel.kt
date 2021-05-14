package com.fatmasatyani.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.vo.Resource

class DetailMovieViewModel(private val listRepository: MovieCatalogueRepository) : ViewModel() {

    var movieId: Int = 0

    fun setSelectedMovie(): LiveData<Resource<Movie>> {
        return listRepository.getMovie(movieId)
    }
}
