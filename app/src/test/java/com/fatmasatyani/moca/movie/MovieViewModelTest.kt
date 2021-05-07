package com.fatmasatyani.moca.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.utils.FakeData
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class MovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: MovieViewModel
    private var repository = mock(ListRepository::class.java)
    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovie() {

        val page = 1
        val movie: MutableLiveData<List<Movie>> = MutableLiveData()
        val observer = mock(Observer::class.java) as Observer<List<Movie>>
        val dummyMovie = (FakeData.generateDummyMovie())

        movie.postValue(dummyMovie)
        `when`(repository.getListMovies(page)).thenReturn(movie)
        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}


