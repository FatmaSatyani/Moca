package com.fatmasatyani.moca.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository

class TvShowViewModel(private val listRepository: MovieCatalogueRepository) : ViewModel() {

    var page = 1

    fun getTvShow(): LiveData<List<TvShow>> {
        return listRepository.getListTvShows(page)
    }
}