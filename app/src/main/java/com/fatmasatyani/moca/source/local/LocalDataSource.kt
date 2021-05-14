package com.fatmasatyani.moca.source.local

import android.content.Context
import androidx.lifecycle.LiveData
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

    fun getAllMovies(movieList: String): LiveData<List<Movie>> = movieDao.getList()

    fun getMovieById (id: Int): LiveData<Movie> = movieDao.getMovieById(id)

    fun insertMovies (movie: List<Movie>) = movieDao.insert(movie)

    fun getFavoriteMovies(): LiveData<List<FavoriteMovieData>> = movieDao.getFavoriteMovie()

    fun addFavoriteMovie (favoriteMovie: Movie) = movieDao.addFavoriteMovie(favoriteMovie)

    fun isFavoriteMovie (movie: Movie): Boolean {
        return movie.id?.let { movieDao.getMovieById(it) } != null}

    fun removeFavoriteMovie (favMovieId: Movie) = movieDao.removeFavoriteMovie(favMovieId)

    fun getAllTvShows () : LiveData<List<TvShow>> = tvShowDao.getList()

    fun getTvShowById (id: Int): TvShow = tvShowDao.getTvShowById(id)

    fun insertTvShow (tvShow: List<TvShow>) = tvShowDao.insert(tvShow)

    fun getFavoriteTvShows(): LiveData<List<FavoriteTvShowData>> = tvShowDao.getFavoriteTvShow()

    fun addFavoriteTvShows (favoriteTvShow: TvShow) = tvShowDao.addFavoriteTvShow(favoriteTvShow)

    fun isFavoriteTvShow (tvShow: TvShow): Boolean {
        return tvShow.id?.let { tvShowDao.getTvShowById(it) } != null}

    fun getSingleFavoriteTvShow (favTvShowId: Int): FavoriteTvShowData = tvShowDao.getSingleTvShowFavorite(favTvShowId)

    fun removeFavoriteTvShow (favTvShowId: Int) = tvShowDao.removeFavoriteTvShow(favTvShowId)
}