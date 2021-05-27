package com.fatmasatyani.moca.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fatmasatyani.core.data.entity.FavoriteTvShowData
import com.fatmasatyani.core.data.source.MovieCatalogueRepository
import com.fatmasatyani.core.utils.Resource
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: com.fatmasatyani.favorite.tvshow.FavoriteTvShowViewModel
    private var repository = Mockito.mock(MovieCatalogueRepository::class.java)
    private val favoriteTvShow: PagedList<FavoriteTvShowData> = mock()

    @Before
    fun setUp() {
        viewModel = com.fatmasatyani.favorite.tvshow.FavoriteTvShowViewModel(repository)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyFavoriteTvShow = Resource.success(favoriteTvShow)
        val favorite = MutableLiveData<Resource<PagedList<FavoriteTvShowData>>>()
        favorite.value = dummyFavoriteTvShow

        val fav: LiveData<PagedList<FavoriteTvShowData>> = mock()
        Mockito.`when`(repository.getAllFavoriteTvShow()).thenReturn(fav)
        val observer = Mockito.mock(Observer::class.java) as Observer<PagedList<FavoriteTvShowData>>
        viewModel.getFavTvShow().observeForever(observer)
    }
}