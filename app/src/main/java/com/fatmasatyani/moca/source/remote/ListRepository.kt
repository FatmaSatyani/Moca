package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.local.LocalRepository

class ListRepository(private val remoteRepository: RemoteRepository, private val localRepository: LocalRepository): ListDataSource {

    companion object {
        fun getInstance(remoteRepository: RemoteRepository, localRepository: LocalRepository): ListRepository {
            return ListRepository(remoteRepository, localRepository)
        }
    }

    override fun getListMovies(page: Int): LiveData<List<Movie>> {
        return remoteRepository.getMovie().map { it.map { movie->
            Movie(
                movie.id,
                movie.backdropPath,
                movie.overview,
                movie.releaseDate,
                movie.voteAverage,
                movie.runtime,
                movie.title,
                movie.posterPath
            )}
        }
    }

    override fun getMovie(id: Int): LiveData<Movie> {
        return remoteRepository.getMovieById(id).map { movie ->
            Movie(
                movie.id,
                movie.backdropPath,
                movie.overview,
                movie.releaseDate,
                movie.voteAverage,
                movie.runtime,
                movie.title,
                movie.posterPath
            )
        }
    }

    override fun getListTvShows(page: Int): LiveData<List<TvShow>> {
        return remoteRepository.getTvShow().map { it.map { tvShow ->
            TvShow(
                tvShow.id,
                tvShow.backdropPath,
                tvShow.overview,
                tvShow.firstAirDate,
                tvShow.voteAverage,
                tvShow.name,
                tvShow.posterPath
            )}
        }
    }

    override fun getTvShow(id: Int): LiveData<TvShow> {
        return remoteRepository.getTvShowById(id).map { tvShow ->
            TvShow(
                tvShow.id,
                tvShow.backdropPath,
                tvShow.overview,
                tvShow.firstAirDate,
                tvShow.voteAverage,
                tvShow.name,
                tvShow.posterPath
            )
        }
    }
}