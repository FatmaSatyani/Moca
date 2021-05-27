package com.fatmasatyani.moca.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.data.source.MovieCatalogueRepository
import com.fatmasatyani.moca.utils.FakeData
import com.fatmasatyani.core.utils.Resource
import com.nhaarman.mockitokotlin2.mock
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DetailTvShowViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: DetailTvShowViewModel
    private var repository = mock(MovieCatalogueRepository::class.java)
    private val tvShow: TvShow = mock()

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(repository)
        viewModel.tvShowId = 1
    }

    @Test
    fun getMovie() {

        val dummyTvShow = Resource.success(tvShow)
        Mockito.`when`(dummyTvShow.data?.name).thenReturn(FakeData.getSingleDummyTvShow().name)

        val dummyLiveData = MutableLiveData<Resource<TvShow>>()
        dummyLiveData.value = dummyTvShow
        Mockito.`when`(repository.getTvShow(1)).thenReturn(dummyLiveData)

        val observer = mock(Observer::class.java) as Observer<Resource<TvShow>>
        viewModel.setSelectedTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)

        TestCase.assertNotNull(viewModel.setSelectedTvShow().value)
        val tvShowResult = viewModel.setSelectedTvShow().value?.data
        assertNotNull(tvShowResult)
        assertEquals(dummyTvShow.data?.id, tvShowResult?.id)
        assertEquals(dummyTvShow.data?.backdropPath, tvShowResult?.backdropPath)
        assertEquals(dummyTvShow.data?.overview, tvShowResult?.overview)
        assertEquals(dummyTvShow.data?.voteAverage, tvShowResult?.voteAverage)
        assertEquals(dummyTvShow.data?.firstAirDate, tvShowResult?.firstAirDate)
        assertEquals(dummyTvShow.data?.name, tvShowResult?.name)
        assertEquals(dummyTvShow.data?.posterPath, tvShowResult?.posterPath)
    }
}
