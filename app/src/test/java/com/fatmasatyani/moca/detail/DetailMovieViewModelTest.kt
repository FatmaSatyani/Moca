package com.fatmasatyani.moca.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.utils.FakeData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
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
    private var repository = mock(ListRepository::class.java)
    private var dataDummyMovie = FakeData.generateDummyMovie()
    private var movieId = dataDummyMovie[1]

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
        viewModel.movieId = 1
    }

    @Test
    fun getMovie() {
        val movie: MutableLiveData<Movie> = MutableLiveData()
        movie.postValue (movieId)
        `when`(repository.getMovie(1)).thenReturn(movie)

        val observer = mock (Observer::class.java) as Observer<Movie>
        viewModel.setSelectedMovie().observeForever(observer)
        verify(observer).onChanged(movieId)

        assertNotNull(viewModel.setSelectedMovie().value)
        val movieResult = viewModel.setSelectedMovie().value
        assertNotNull(movieResult)
        assertEquals(movieId.id,movieResult?.id)
        assertEquals(movieId.title,movieResult?.title)
        assertEquals(movieId.backdropPath, movieResult?.backdropPath)
        assertEquals(movieId.overview,movieResult?.overview)
        assertEquals(movieId.posterPath, movieResult?.posterPath)
        assertEquals(movieId.releaseDate,movieResult?.releaseDate)
        assertEquals(movieId.runtime, movieResult?.runtime)
        assertEquals(movieId.voteAverage, movieResult?.voteAverage)
    }
}


