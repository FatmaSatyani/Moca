package com.fatmasatyani.moca.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.ListRepository
import com.fatmasatyani.moca.utils.FakeData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class DetailTvShowViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: DetailTvShowViewModel
    private var repository = Mockito.mock(ListRepository::class.java)
    private var dataDummyTvShow = FakeData.generateDummyTvShow()
    private var tvShowId = dataDummyTvShow[1]

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(repository)
        viewModel.tvShowId = 1
    }

    @Test
    fun getTvShow() {
        val tvShow: MutableLiveData<TvShow> = MutableLiveData()
        tvShow.postValue(tvShowId)
        Mockito.`when`(repository.getTvShow(1)).thenReturn(tvShow)

        val observer = Mockito.mock(Observer::class.java) as Observer<TvShow>
        viewModel.setSelectedTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(tvShowId)

        assertNotNull(viewModel.setSelectedTvShow().value)
        val tvShowResult = viewModel.setSelectedTvShow().value
        assertNotNull(tvShowResult)
        assertEquals(tvShowId.id, tvShowResult?.id)
        assertEquals(tvShowId.name,tvShowResult?.name)
        assertEquals(tvShowId.backdropPath, tvShowResult?.backdropPath)
        assertEquals(tvShowId.overview, tvShowResult?.overview)
        assertEquals(tvShowId.firstAirDate, tvShowResult?.firstAirDate)
        assertEquals(tvShowId.posterPath,tvShowResult?.posterPath)
        assertEquals(tvShowId.voteAverage, tvShowResult?.voteAverage)
    }
}
