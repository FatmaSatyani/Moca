package com.fatmasatyani.moca.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.load.engine.Resource
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.MovieDetailResponse
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response.success
import retrofit2.http.GET

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {



    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: DetailMovieViewModel
    private var repository = mock(ListRepository::class.java)
    private var dummyMovie = DataDummy.generateDummyMovie()[0]
    private var movieId = dummyMovie.id
    private var

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
        viewModel.movieId = movieId
    }

    @Test
    fun getMovie() {
        val movie: MutableLiveData<MovieDetailResponse> = MutableLiveData()
        val resourceMovie: Resource<Movie> = Resource.success(dummyMovie)
        movie.postValue(dummyMovie)
        `when`(repository.getMovie(movieId)).thenReturn(movie)
        val observer = mock (Observer::class.java) as Observer<Movie>
        viewModel.setSelectedMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}