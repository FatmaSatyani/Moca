package com.fatmasatyani.moca.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.FavoriteTvShowData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.local.LocalDataSource
import com.fatmasatyani.moca.utils.FakeData
import com.fatmasatyani.moca.utils.PagedListUtils
import com.fatmasatyani.moca.vo.Resource
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class MovieCatalogueRepositoryTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private var localDataSource= mock(LocalDataSource::class.java)
    private var repository = mock(MovieCatalogueRepository::class.java)

    private val dummyMovieEntities: List<Movie> = FakeData.generateDummyMovie()
    private val dummyTvShowEntities: List<TvShow> = FakeData.generateDummyTvShow()
    private val dummyFavoriteMovie: List<FavoriteMovieData> = FakeData.getFavoriteDummyMovie()
    private val dummyFavoriteTvShow: List<FavoriteTvShowData> = FakeData.getFavoriteDummyTvShow()

    @Test

//    ------------------  Movie  ------------------
    fun getListMovie() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(localDataSource.getAllMovies()).thenReturn(dataSource)
        repository.getMovie(1)

        val movieResult = Resource.success(PagedListUtils.mockPagedList(dummyMovieEntities))
        assertNotNull(movieResult.data)
        assertEquals(dummyMovieEntities.size, movieResult.data?.size)
    }

    @Test
    fun getMovie() {
        val movie: LiveData<Movie> = mock()
        `when`(localDataSource.getMovieById(0)).thenReturn(movie)
        repository.getMovie(0)
    }

    @Test
    fun getAllFavoriteMovies() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteMovieData>
        `when`(localDataSource.getFavoriteMovies()).thenReturn(dataSource)
        repository.getAllFavoriteMovies()

        val favoriteMovieResult = Resource.success(PagedListUtils.mockPagedList(dummyFavoriteMovie))
        assertNotNull(favoriteMovieResult.data)
        assertEquals(dummyFavoriteMovie.size, favoriteMovieResult.data?.size)
    }

    @Test
    fun addFavoriteMovie() {
        val favoriteMovie : Movie = mock()
        val dummyFavoriteMovie = Resource.success(favoriteMovie)
        dummyFavoriteMovie.data

        `when`(dummyFavoriteMovie.data?.title).thenReturn(FakeData.getSingleFavoriteMovie().title)
        val result = repository.addFavoriteMovie(favoriteMovie)
        verify(repository).addFavoriteMovie(favoriteMovie)
        assertNotNull(result)
    }

    @Test
    fun removeFavoriteMovie() {
        val favoriteMovie: Movie = mock()
        val dummyFavorite = Resource.success(favoriteMovie)
        dummyFavorite.data

        `when`(dummyFavorite.data?.title).thenReturn(FakeData.getSingleFavoriteMovie().title)
        val result = repository.removeFavoriteMovie(favoriteMovie)
        verify(repository).removeFavoriteMovie(favoriteMovie)
        assertNotNull(result)
    }

    @Test
    fun isFavoriteMovie() {
        val movie : Movie = mock()
        val favoriteData = MutableLiveData<Boolean>()
        favoriteData.value = true

        val favMovie: LiveData<Movie> = mock()
        `when`(localDataSource.getMovieById(1)).thenReturn(favMovie)
        val result = repository.isFavoriteMovie(movie)
        assertNotNull(result)
        assertEquals(false,result)

    }

    @Test
    fun isFavoriteMovieById() {
        val movie: Movie = mock()
        val favoriteData = MutableLiveData<Boolean>()
        favoriteData.value = true

        `when`(localDataSource.isFavoriteMovieById(movie)).thenReturn(favoriteData.value)
        val result = repository.isFavoriteMovie(movie)
        assertNotNull(result)
        assertEquals(false,result)
    }

//    ------------------  Tv Show ------------------
    @Test
    fun getListTvShow() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(localDataSource.getAllTvShows()).thenReturn(dataSource)
        repository.getTvShow(1)

        val tvShowResult = Resource.success(PagedListUtils.mockPagedList(dummyTvShowEntities))
        assertNotNull(tvShowResult.data)
        assertEquals(dummyTvShowEntities.size, tvShowResult.data?.size)
    }

    @Test
    fun getTvShow() {
        val tvShow: LiveData<TvShow> = mock()
        `when`(localDataSource.getTvShowById(0)).thenReturn(tvShow)
        repository.getTvShow(0)
    }

    @Test
    fun getAllFavoriteTvShow() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FavoriteTvShowData>
        `when`(localDataSource.getFavoriteTvShows()).thenReturn(dataSource)
        repository.getAllFavoriteTvShow()

        val favoriteTvShowResult = Resource.success(PagedListUtils.mockPagedList(dummyFavoriteTvShow))
        assertNotNull(favoriteTvShowResult.data)
        assertEquals(dummyFavoriteTvShow.size, favoriteTvShowResult.data?.size)
    }

    @Test
    fun addFavoriteTvShow() {
        val favoriteTvShow : TvShow = mock()
        val dummyFavorite = Resource.success(favoriteTvShow)
        dummyFavorite.data

        `when`(dummyFavorite.data?.name).thenReturn(FakeData.getSingleFavoriteTvShow().name)
        val result = repository.addFavoriteTvShow(favoriteTvShow)
        verify(repository).addFavoriteTvShow(favoriteTvShow)
        assertNotNull(result)
    }


    @Test
    fun removeFavoriteTvShow() {
        val favoriteTvShow: TvShow = mock()
        val dummyFavorite = Resource.success(favoriteTvShow)
        dummyFavorite.data

        `when`(dummyFavorite.data?.name).thenReturn(FakeData.getSingleFavoriteTvShow().name)
        val result = repository.removeFavoriteTvShow(favoriteTvShow)
        verify(repository).removeFavoriteTvShow(favoriteTvShow)
        assertNotNull(result)
    }

    @Test
    fun isFavoriteTvShow() {
        val tvShow: TvShow = mock()
        val favoriteData = MutableLiveData<Boolean>()
        favoriteData.value = true

        val favTvShow: LiveData<TvShow> = mock()
        `when`(localDataSource.getTvShowById(1)).thenReturn(favTvShow)
        val result = repository.isFavoriteTvShow(tvShow)
        assertNotNull(result)
        assertEquals(false,result)
    }

    @Test
    fun isFavoriteTvShowById() {
        val tvShow: TvShow = mock()
        val favoriteData = MutableLiveData<Boolean>()
        favoriteData.value = true

        `when`(localDataSource.isFavoriteTvShowById(tvShow)).thenReturn(favoriteData.value)
        val result = repository.isFavoriteTvShow(tvShow)
        assertNotNull(result)
        assertEquals(false,result)
    }
}