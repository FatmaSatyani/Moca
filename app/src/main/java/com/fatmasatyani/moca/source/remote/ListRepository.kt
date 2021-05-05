package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.local.LocalRepository
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse

class ListRepository (private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository): ListDataSource {

    companion object {
        fun getInstance(remoteRepository: RemoteRepository, localRepository: LocalRepository): ListRepository {
            return ListRepository(localRepository, remoteRepository)
        }
    }

    override fun getListMovies(page: Int): LiveData<List<Movie>> {
        return remoteRepository.getMovie(page)
    }

    override fun getMovie(id: Int): LiveData<Movie> {
        return remoteRepository.getMovieById(id)
    }

    override fun getListTvShows(page: Int): LiveData<List<TvShow>> {
        return remoteRepository.getTvShow(page)
    }

    override fun getTvShow(id: Int): LiveData<TvShow> {
        return remoteRepository.getTvShowById(id)
    }
}