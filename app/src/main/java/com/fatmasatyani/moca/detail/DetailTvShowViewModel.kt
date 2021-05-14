package com.fatmasatyani.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.vo.Resource

class DetailTvShowViewModel(private val listRepository: MovieCatalogueRepository) : ViewModel() {

    var tvShowId: Int = 0

    fun setSelectedTvShow(): LiveData<Resource<TvShow>> {
        return listRepository.getTvShow(tvShowId)
    }
}