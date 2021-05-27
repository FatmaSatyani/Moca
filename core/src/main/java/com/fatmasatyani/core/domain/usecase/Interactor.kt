package com.fatmasatyani.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.fatmasatyani.core.data.entity.FavoriteMovieData
import com.fatmasatyani.core.data.entity.FavoriteTvShowData
import com.fatmasatyani.core.data.entity.Movie
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.core.domain.repository.IMocaRepository
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.flow.Flow

class Interactor (private val repository: IMocaRepository) : MocaUseCase {
    override fun getListMovie(): Flow<Resource<List<MovieModel>>> = repository.getListMovie()

//    override fun getMovie(id: Int) = repository.getMovie(id).asLiveData()

    override fun getAllFavoriteMovie() : Flow<List<FavoriteMovieModel>> = repository.getAllFavoriteMovie()

    override fun addFavoriteMovie(movie: FavoriteMovieModel) = repository.addFavoriteMovie(movie)

    override fun removeFavoriteMovie(movie: FavoriteMovieModel) = repository.removeFavoriteMovie(movie)

    override fun isFavoriteMovie(movie: MovieModel): Boolean = repository.isFavoriteMovie(movie)

//    override fun isFavoriteMovieById(movie: MovieModel): Boolean = repository.isFavoriteMovieById(movie)

    override fun getListTvShow(): Flow<Resource<List<TvShowModel>>> = repository.getListTvShow()

//    override fun getTvShow(id: Int): LiveData<Resource<TvShow>> = repository.getTvShow(id).asLiveData()

    override fun getAllFavoriteTvShow(): Flow<List<FavoriteTvShowModel>> = repository.getAllFavoriteTvShow()

    override fun addFavoriteTvShow(tvShow: FavoriteTvShowModel) = repository.addFavoriteTvShow(tvShow)

    override fun removeFavoriteTvShow(tvShow: FavoriteTvShowModel) = repository.removeFavoriteTvShow(tvShow)

    override fun isFavoriteTvShow(tvShow: TvShowModel): Boolean = repository.isFavoriteTvShow(tvShow)

//    override fun isFavoriteTvShowById(tvShow: TvShow): Boolean = repository.isFavoriteTvShowById(tvShow)

}