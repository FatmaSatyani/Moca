package com.fatmasatyani.core.data.source.local

import android.content.Context
import com.fatmasatyani.core.data.dao.MovieDao
//import com.fatmasatyani.core.data.dao.TvShowDao
import com.fatmasatyani.core.data.entity.FavoriteMovieData
//import com.fatmasatyani.core.data.entity.FavoriteTvShowData
import com.fatmasatyani.core.data.entity.Movie
//import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.domain.model.MovieModel
//import com.fatmasatyani.core.domain.model.TvShowModel
import kotlinx.coroutines.flow.Flow

class LocalDataSource(context: Context) {

    private val movieDao: MovieDao
//    private val tvShowDao: TvShowDao

    init {
        val database = AppDatabase.getInstance(context)
        movieDao = database.movieDao()
//        tvShowDao = database.tvShowDao()
    }

    companion object {
        fun getInstance(context: Context): LocalDataSource {
            return LocalDataSource(context)
        }
    }

    fun getAllMovies(): Flow<List<Movie>> = movieDao.getList()

    fun getMovieById (id: Int): Flow<List<Movie>> = movieDao.getMovieById(id)

    fun insertMovies (movie: List<Movie>) = movieDao.insert(movie)

    fun getFavoriteMovies(): Flow<FavoriteMovieData> = movieDao.getFavoriteMovie()

    fun addFavoriteMovie (favoriteMovie: FavoriteMovieData) = movieDao.addFavoriteMovie(favoriteMovie)

    fun isFavoriteMovie (movie: Movie): Boolean {
        return movie.id?.let { movieDao.getMovieById(it) } != null}

    fun isFavoriteMovieById (movie: MovieModel): Boolean {
        return movieDao.getFavoriteMovieById(movie.movieId) != null}

    fun removeFavoriteMovie (favMovieId: Int) = movieDao.removeFavoriteMovie(favMovieId)

//    fun getAllTvShows () : Flow<List<TvShow>> = tvShowDao.getList()
//
//    fun getTvShowById (id: Int): Flow<TvShow> = tvShowDao.getTvShowById(id)
//
//    fun insertTvShow (tvShow: List<TvShow>) = tvShowDao.insert(tvShow)
//
//    fun getFavoriteTvShows(): Flow<FavoriteTvShowData> = tvShowDao.getFavoriteTvShow()
//
//    fun addFavoriteTvShows (favoriteTvShow: FavoriteTvShowData) = tvShowDao.addFavoriteTvShow(favoriteTvShow)
//
//    fun isFavoriteTvShow (tvShow: TvShow): Boolean {
//        return tvShow.id?.let { tvShowDao.getTvShowById(it) } != null}
//
//    fun isFavoriteTvShowById (tvShow: TvShowModel): Boolean {
//        return tvShowDao.getFavoriteTvShowById(tvShow.tvShowId ?: 0) != null}
//
//    fun removeFavoriteTvShow (favTvShowId: Int) = tvShowDao.removeFavoriteTvShow(favTvShowId)
}