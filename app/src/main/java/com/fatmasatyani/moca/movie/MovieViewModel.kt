package com.fatmasatyani.moca.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.ListRepository

class MovieViewModel(private val listRepository: ListRepository) : ViewModel() {

    var page = 1

    fun getMovie(): LiveData<List<Movie>> {
//        Log.d("ViewModelCheck",list.value.toString())
        return listRepository.getListMovies(page)
    }
}
//    var page = 1
//
//    fun getTvShow(): LiveData<List<TvShow>> {
//        return listRepository.getListTvShows(page)
//    }
//}