package com.fatmasatyani.moca.source.local

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.fatmasatyani.moca.dao.MovieDao
import com.fatmasatyani.moca.dao.TvShowDao
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.FavoriteTvShowData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow

class LocalDataSource(context: Context) {

    private val movieDao: MovieDao
    private val tvShowDao: TvShowDao

    init {
        val database = AppDatabase.getInstance(context)
        movieDao = database.movieDao()
        tvShowDao = database.tvShowDao()
    }

    companion object {
        fun getInstance(context: Context): LocalDataSource {
            return LocalDataSource(context)
        }
    }

    fun getAllMovies(): DataSource.Factory<Int, Movie> = movieDao.getList()

    fun getMovieById (id: Int): LiveData<Movie> = movieDao.getMovieById(id)

    fun insertMovies (movie: List<Movie>) = movieDao.insert(movie)

    fun getFavoriteMovies(): DataSource.Factory<Int, FavoriteMovieData> = movieDao.getFavoriteMovie()

    fun addFavoriteMovie (favoriteMovie: FavoriteMovieData) = movieDao.addFavoriteMovie(favoriteMovie)

    fun isFavoriteMovie (movie: Movie): Boolean {
        return movie.id?.let { movieDao.getMovieById(it) } != null}

    fun isFavoriteMovieById (movie: Movie): Boolean {
        return movieDao.getFavoriteMovieById(movie.id ?: 0) != null}

    fun removeFavoriteMovie (favMovieId: FavoriteMovieData) = movieDao.removeFavoriteMovie(favMovieId.movieId)

    fun getAllTvShows () : DataSource.Factory<Int, TvShow> = tvShowDao.getList()

    fun getTvShowById (id: Int): LiveData<TvShow> = tvShowDao.getTvShowById(id)

    fun insertTvShow (tvShow: List<TvShow>) = tvShowDao.insert(tvShow)

    fun getFavoriteTvShows(): DataSource.Factory<Int, FavoriteTvShowData> = tvShowDao.getFavoriteTvShow()

    fun addFavoriteTvShows (favoriteTvShow: FavoriteTvShowData) = tvShowDao.addFavoriteTvShow(favoriteTvShow)

    fun isFavoriteTvShow (tvShow: TvShow): Boolean {
        return tvShow.id?.let { tvShowDao.getTvShowById(it) } != null}

    fun isFavoriteTvShowById (tvShow: TvShow): Boolean {
        return tvShowDao.getFavoriteTvShowById(tvShow.id ?: 0) != null}

    fun removeFavoriteTvShow (favTvShowId: FavoriteTvShowData) = tvShowDao.removeFavoriteTvShow(favTvShowId.tvShowId)
}