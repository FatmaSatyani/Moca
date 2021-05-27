package com.fatmasatyani.moca.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.core.data.entity.Movie
import com.fatmasatyani.core.data.source.MovieCatalogueRepository
import com.fatmasatyani.moca.utils.FakeData
import com.fatmasatyani.core.utils.Resource
import com.nhaarman.mockitokotlin2.mock
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: DetailMovieViewModel
    private var repository = mock(MovieCatalogueRepository::class.java)
    private val movie: Movie = mock()

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
        viewModel.movieId = 1
    }

    @Test
    fun getMovie() {

        val dummyMovie = Resource.success(movie)
        `when`(dummyMovie.data?.title).thenReturn(FakeData.getSingleDummyMovie().title)

        val dummyLiveData = MutableLiveData<Resource<Movie>>()
        dummyLiveData.value = dummyMovie
        `when`(repository.getMovie(1)).thenReturn(dummyLiveData)

        val observer = mock(Observer::class.java) as Observer<Resource<Movie>>
        viewModel.setSelectedMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

        assertNotNull(viewModel.setSelectedMovie().value)
        val movieResult = viewModel.setSelectedMovie().value?.data
        assertNotNull(movieResult)
        assertEquals(dummyMovie.data?.id, movieResult?.id)
        assertEquals(dummyMovie.data?.backdropPath, movieResult?.backdropPath)
        assertEquals(dummyMovie.data?.overview, movieResult?.overview)
        assertEquals(dummyMovie.data?.releaseDate, movieResult?.releaseDate)
        assertEquals(dummyMovie.data?.voteAverage, movieResult?.voteAverage)
        assertEquals(dummyMovie.data?.runtime,movieResult?.runtime)
        assertEquals(dummyMovie.data?.title, movieResult?.title)
        assertEquals(dummyMovie.data?.posterPath, movieResult?.posterPath)

    }
}





