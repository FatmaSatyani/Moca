package com.fatmasatyani.moca.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.movie.MovieViewModel
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.utils.DataDummy
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class TvShowViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: TvShowViewModel
    private var repository = Mockito.mock(ListRepository::class.java)

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShow() {
        val page = 1
        val tvShow: MutableLiveData<List<TvShow>> = MutableLiveData()
        val observer = Mockito.mock(Observer::class.java) as Observer<List<TvShow>>
        val dummyTvShow = DataDummy.generateDummyTvShow()
        tvShow.postValue(dummyTvShow)
        Mockito.`when`(repository.getListTvShows(1)).thenReturn(tvShow)
        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}