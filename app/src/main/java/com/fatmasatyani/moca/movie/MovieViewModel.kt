package com.fatmasatyani.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.domain.usecase.MocaUseCase
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.flow.Flow

class MovieViewModel(private val mocaUseCase: MocaUseCase) : ViewModel() {

    var page = 1

    fun getMovie(): LiveData<Resource<List<MovieModel>>> =
        mocaUseCase.getListMovie().asLiveData()
}
