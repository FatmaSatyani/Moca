package com.fatmasatyani.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.vo.Resource

class MovieViewModel(private val listRepository: MovieCatalogueRepository) : ViewModel() {

    var page = 1

    fun getMovie(): LiveData<Resource<PagedList<Movie>>> {
        return listRepository.getListMovies(page)
    }
}
