package com.fatmasatyani.moca.tvshow

import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.TvShowEntity
import com.fatmasatyani.moca.utils.Data

class TvShowViewModel : ViewModel() {

    val tvShow: List<TvShowEntity> = Data.generateTvShow()
    fun getTvShow (id: String): TvShowEntity? = Data.tvShowDetails(id)

}