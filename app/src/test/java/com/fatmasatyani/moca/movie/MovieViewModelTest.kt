package com.fatmasatyani.moca.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.MovieCatalogueRepository
import com.fatmasatyani.moca.vo.Resource
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class MovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: MovieViewModel
    private var repository = mock(MovieCatalogueRepository::class.java)
    private val movie: PagedList<Movie> = mock()

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.success(movie)
        `when`(dummyMovie.data?.size).thenReturn(3)
        val movie = MutableLiveData<Resource<PagedList<Movie>>>()
        movie.value = dummyMovie

        `when`(repository.getListMovies(1)).thenReturn(movie)
        val movieResult = viewModel.getMovie().value?.data
        verify(repository).getListMovies(1)
        assertNotNull(movieResult)
        assertEquals(3,movieResult?.count())

        val observer = mock(Observer::class.java) as Observer<Resource<PagedList<Movie>>>
        `when`(repository.getListMovies(1)).thenReturn(movie)
        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }
}


