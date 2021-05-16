package com.fatmasatyani.moca.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.vo.Resource
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
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
    private var repository = mock(MovieCatalogueRepository::class.java)
    private val tvShow: PagedList<TvShow> = mock()

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getMovie() {
        val dummyTvShow = Resource.success(tvShow)
        Mockito.`when`(dummyTvShow.data?.size).thenReturn(3)
        val tvShow = MutableLiveData<Resource<PagedList<TvShow>>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(repository.getListTvShows(1)).thenReturn(tvShow)
        val tvShowResult = viewModel.getTvShow().value?.data
        Mockito.verify(repository).getListTvShows(1)
        Assert.assertNotNull(tvShowResult)
        Assert.assertEquals(3, tvShowResult?.count())

        val observer = mock(Observer::class.java) as Observer<Resource<PagedList<TvShow>>>
        Mockito.`when`(repository.getListTvShows(1)).thenReturn(tvShow)
        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)

    }
}