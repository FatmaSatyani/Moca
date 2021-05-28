package com.fatmasatyani.moca.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fatmasatyani.core.domain.usecase.MocaUseCase

class HomeViewModel(private val mocaUseCase: MocaUseCase) : ViewModel() {

    var page = 1

    val movie = mocaUseCase.getListMovie().asLiveData()

//    fun getMovie(): LiveData<Resource<List<MovieModel>>> =
//        mocaUseCase.getListMovie().asLiveData()
}
