package com.fatmasatyani.moca.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.vo.Resource

class TvShowViewModel(private val listRepository: MovieCatalogueRepository) : ViewModel() {

    var page = 1

    fun getTvShow(): LiveData<Resource<PagedList<TvShow>>> {
        return listRepository.getListTvShows(page)
    }
}