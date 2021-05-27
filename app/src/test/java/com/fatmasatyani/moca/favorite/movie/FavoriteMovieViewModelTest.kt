package com.fatmasatyani.moca.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fatmasatyani.core.data.entity.FavoriteMovieData
import com.fatmasatyani.core.data.source.MovieCatalogueRepository
import com.fatmasatyani.core.utils.Resource
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: com.fatmasatyani.favorite.movie.FavoriteMovieViewModel
    private var repository = mock(MovieCatalogueRepository::class.java)
    private val favoriteMovie: PagedList<FavoriteMovieData> = mock()

    @Before
    fun setUp() {
        viewModel = com.fatmasatyani.favorite.movie.FavoriteMovieViewModel(repository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyFavoriteMovie= Resource.success(favoriteMovie)
        val favorite = MutableLiveData<Resource<PagedList<FavoriteMovieData>>>()
        favorite.value = dummyFavoriteMovie

        val fav: LiveData<PagedList<FavoriteMovieData>> = mock()
        Mockito.`when`(repository.getAllFavoriteMovies()).thenReturn(fav)
        val observer = mock(Observer::class.java) as Observer<PagedList<FavoriteMovieData>>
        viewModel.getFavMovie().observeForever(observer)
    }
}