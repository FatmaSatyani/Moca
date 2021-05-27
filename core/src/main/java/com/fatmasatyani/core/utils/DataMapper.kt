package com.fatmasatyani.core.utils

import com.fatmasatyani.core.data.source.remote.response.MovieDetailResponse
import com.fatmasatyani.core.data.source.remote.response.TvShowDetailResponse
import com.fatmasatyani.core.data.entity.FavoriteMovieData
import com.fatmasatyani.core.data.entity.FavoriteTvShowData
import com.fatmasatyani.core.data.entity.Movie
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.domain.model.TvShowModel

object DataMapper {

    fun mapMovieDetailResponsesToMovie(input: List<MovieDetailResponse>): List<Movie> {
        val movieList = mutableListOf<Movie>()
        input.map {
            val movie = Movie (
                it.id,
                it.backdropPath,
                it.overview,
                it.releaseDate,
                it.voteAverage,
                it.runtime,
                it.title,
                it.posterPath
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapTvShowDetailResponsesToTvShow(input: List<TvShowDetailResponse>): List<TvShowModel> {
        val tvShowList = mutableListOf<TvShowModel>()
        input.map {
            val tvShow = TvShowModel (
                it.id,
                it.backdropPath,
                it.overview,
                it.firstAirDate,
                it.voteAverage,
                it.name,
                it.posterPath
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun mapMovieEntitiesToDomain(input: List<Movie>): List<MovieModel> =
        input.map {
            MovieModel(
                it.id,
                it.backdropPath,
                it.overview,
                it.releaseDate,
                it.voteAverage,
                it.runtime,
                it.title,
                it.posterPath
            )
        }

    fun mapTvShowEntitiesToDomain(input: List<TvShow>): List<TvShowModel> =
        input.map {
            TvShowModel(
                it.id,
                it.backdropPath,
                it.overview,
                it.firstAirDate,
                it.voteAverage,
                it.name,
                it.posterPath
            )
        }

    fun mapFavMovEntitiesToFavMovDomain(input: List<Movie>): List<FavoriteMovieModel> =
        input.map {
            FavoriteMovieModel(
                it.id,
                it.id,
                it.backdropPath,
                it.overview,
                it.releaseDate,
                it.voteAverage,
                it.runtime,
                it.title,
                it.posterPath
            )
        }

    fun mapFavTvEntitiesToFavTvDomain(input: List<TvShow>): List<FavoriteTvShowModel> =
        input.map {
            FavoriteTvShowModel(
                it.id,
                it.id,
                it.backdropPath,
                it.overview,
                it.firstAirDate,
                it.voteAverage,
                it.name,
                it.posterPath
            )
        }

    fun mapFavMovieToMovie (favMov: FavoriteMovieModel): MovieModel =
        MovieModel(
            favMov.MovId,
            favMov.backdrop,
            favMov.overview,
            favMov.releaseDate,
            favMov.voteAverage,
            favMov.runtime,
            favMov.title,
            favMov.poster
        )

    fun mapDomainToFavMovEntities (input: FavoriteMovieModel): FavoriteMovieData =
        FavoriteMovieData(
            0,
            input.MovId,
            input.backdrop,
            input.overview,
            input.releaseDate,
            input.voteAverage,
            input.runtime,
            input.title,
            input.poster
        )

    fun mapDomainToFavTvEntities (input: FavoriteTvShowModel): FavoriteTvShowData =
        FavoriteTvShowData(
            0,
            input.tvShowId,
            input.backdrop,
            input.overview,
            input.firstAirDate,
            input.voteAverage,
            input.name,
            input.poster
        )
}
