package com.fatmasatyani.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.ListRepository

class DetailTvShowViewModel(private val listRepository: ListRepository) : ViewModel() {

    var tvShowId: Int = 0

    fun setSelectedTvShow(): LiveData<TvShow> {
        return listRepository.getTvShow(tvShowId)
    }
}