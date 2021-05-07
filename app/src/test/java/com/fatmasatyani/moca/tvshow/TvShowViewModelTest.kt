package com.fatmasatyani.moca.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.utils.FakeData
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class TvShowViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: TvShowViewModel
    private var repository = mock(ListRepository::class.java)

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShow() {
        val page = 1
        val tvShow: MutableLiveData<List<TvShow>> = MutableLiveData()
        val observer = mock(Observer::class.java) as Observer<List<TvShow>>
        val dummyTvShow = FakeData.generateDummyTvShow()
        tvShow.postValue(dummyTvShow)
        Mockito.`when`(repository.getListTvShows(page)).thenReturn(tvShow)
        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }

}