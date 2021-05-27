package com.fatmasatyani.moca.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagedList
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.data.source.MovieCatalogueRepository
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.core.domain.usecase.MocaUseCase
import com.fatmasatyani.core.utils.Resource

class TvShowViewModel(private val mocaUseCase: MocaUseCase) : ViewModel() {

    var page = 1

    fun getTvShow(): LiveData<Resource<List<TvShowModel>>> =
        mocaUseCase.getListTvShow().asLiveData()
}