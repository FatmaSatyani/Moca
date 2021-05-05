package com.fatmasatyani.moca.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.ListRepository

class TvShowViewModel(private val listRepository: ListRepository) : ViewModel() {

//    val tvShow: List<TvShow> = Data.generateTvShow()
//    fun getTvShow (id: String): TvShow? = Data.tvShowDetails(id)

    var page = 1
    fun getTvShow(): LiveData<List<TvShow>> {
        return listRepository.getListTvShows(page)
    }
}