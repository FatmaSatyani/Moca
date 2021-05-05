package com.fatmasatyani.moca.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.tvshow.TvShowAdapter
import com.fatmasatyani.moca.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class DetailTvShowViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: DetailTvShowViewModel
    private var repository = Mockito.mock(ListRepository::class.java)
    private var dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private var tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(repository)
        viewModel.tvShowId = tvShowId
    }

    @Test
    fun getTvShow() {
        val tvShow: MutableLiveData<TvShow> = MutableLiveData()
        tvShow.postValue(dummyTvShow)
        Mockito.`when`(repository.getTvShow(tvShowId)).thenReturn(tvShow)
        val observer = Mockito.mock(Observer::class.java) as Observer<TvShow>
        viewModel.setSelectedTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}