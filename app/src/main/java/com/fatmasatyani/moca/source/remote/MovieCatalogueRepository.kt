package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.MovieDetailResponse
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.NetworkBoundResource
import com.fatmasatyani.moca.source.local.LocalDataSource
import com.fatmasatyani.moca.source.remote.response.ApiResponse
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.utils.AppExecutors
import com.fatmasatyani.moca.utils.EspressoIdlingResource
import com.fatmasatyani.moca.vo.Resource
import java.util.*

class MovieCatalogueRepository private constructor(
    private val remoteRepository: RemoteDataSource,
    private val localRepository: LocalDataSource,
    private val appExecutors: AppExecutors): MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource,localDataSource: LocalDataSource, appExecutors: AppExecutors): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteDataSource, localDataSource, appExecutors)
            }
    }

    override fun getListMovies(page: Int): LiveData<Resource<PagedList<Movie>>> {

        return object: NetworkBoundResource<PagedList<Movie>, MovieResponse>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<Movie>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localRepository.getAllMovies(movieList = ""),config).build()
            }

            override fun shouldFetch(data: PagedList<Movie>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<List<MovieDetailResponse>> =
                remoteRepository.getMovie()

            override fun saveCallResult(data: MovieResponse) {
                val movieList = mutableListOf<Movie>()
                data.result.forEach {
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
                localRepository.insertMovies(movieList)
            }
        }.asLiveData()
    }

//            override fun loadFromDB(): LiveData<PagedList<Movie>> {
//                val config = PagedList.Config.Builder()
//                    .setEnablePlaceholders(false)
//                    .setInitialLoadSizeHint(4)
//                    .setPageSize(4)
//                    .build()
//
//                return liveData(localRepository.getAllMovies(movieList), config).build()
//            }

//            override fun shouldFetch(data: PagedList<Movie>?): Boolean =
//            override fun saveCallResult(data: MovieResponse) {
//                val movieList = mutableListOf<Movie>()
//                    data.result.forEach {
//                        val movie = Movie(
//                            id = it.id,
//                            backdropPath = it.backdropPath,
//                            overview = it.overview,
//                            releaseDate = it.releaseDate,
//                            voteAverage = it.voteAverage,
//                            runtime = it.runtime,
//                            title = it.title,
//                            posterPath = it.posterPath
//                        )
//                    movieList.add(movie)
//                    }
//                return movieList

//    override fun getListMovies(page: Int): LiveData<List<Movie>> {
//        return remoteRepository.getMovie().map { it.map { movie->
//            Movie(
//                movie.id,
//                movie.backdropPath,
//                movie.overview,
//                movie.releaseDate,
//                movie.voteAverage,
//                movie.runtime,
//                movie.title,
//                movie.posterPath
//            )}
//        }
//    }

    override fun getMovie(id: Int): LiveData<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<Movie> =
                localRepository.getMovieById(id)

            override fun shouldFetch(data: Movie?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteRepository.getMovieById(id)

            override fun saveCallResult(data: MovieDetailResponse) {
                val movieList = Movie(
                    id = data.id,
                    backdropPath = data.backdropPath,
                    overview = data.overview,
                    releaseDate = data.releaseDate,
                    voteAverage = data.voteAverage,
                    runtime = data.runtime,
                    title = data.title,
                    posterPath = data.posterPath
                )
//                data.result.forEach {
//                    val movie = Movie (
//                        it.id,
//                        it.backdropPath,
//                        it.overview,
//                        it.releaseDate,
//                        it.voteAverage,
//                        it.runtime,
//                        it.title,
//                        it.posterPath
//                    )
//                    movieList.add(movie)
//                }
                localRepository.addFavoriteMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getListTvShows(page: Int): LiveData<List<TvShow>> {
        TODO("Not yet implemented")
    }

    override fun getTvShow(id: Int): LiveData<TvShow> {
        TODO("Not yet implemented")
    }

//    override fun getMovie(id: Int): LiveData<Movie> {
//        return remoteRepository.getMovieById(id).map { movie ->
//            Movie(
//                movie.id,
//                movie.backdropPath,
//                movie.overview,
//                movie.releaseDate,
//                movie.voteAverage,
//                movie.runtime,
//                movie.title,
//                movie.posterPath
//            )
//        }
//    }
//    override fun getFavoriteMovie(): LiveData<PagedList<Movie>> {
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setInitialLoadSizeHint(4)
//            .setPageSize(4)
//            .build()
//        return LivePagedListBuilder(localRepository.getFavoriteMovies(),config).build()
//    }

//    override fun getListTvShows(page: Int): LiveData<List<TvShow>> {
//        return remoteRepository.getTvShow().map { it.map { tvShow ->
//            TvShow(
//                tvShow.id,
//                tvShow.backdropPath,
//                tvShow.overview,
//                tvShow.firstAirDate,
//                tvShow.voteAverage,
//                tvShow.name,
//                tvShow.posterPath
//            )}
//        }
//    }
//
//    override fun getTvShow(id: Int): LiveData<TvShow> {
//        return remoteRepository.getTvShowById(id).map { tvShow ->
//            TvShow(
//                tvShow.id,
//                tvShow.backdropPath,
//                tvShow.overview,
//                tvShow.firstAirDate,
//                tvShow.voteAverage,
//                tvShow.name,
//                tvShow.posterPath
//            )
//        }
//    }

    override fun getAllFavoriteMovies(): LiveData<PagedList<Movie>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localRepository.getFavoriteMovies(),config).build()
    }


    override fun addFavoriteMovie(movie: Movie) {
        localRepository.addFavoriteMovie(movie)
    }

    override fun removeFavoriteMovie(movie: Movie) {
        localRepository.removeFavoriteMovie(movie)
    }

    override fun isFavoriteMovie(movie: Movie): Boolean =
        localRepository.isFavoriteMovie(movie)

    override fun getAllFavoriteTvShow(): LiveData<PagedList<TvShow>> {
        localRepository.getFavoriteMovies()
    }

    override fun addFavoriteTvShow(tvShow: TvShow) {
        TODO("Not yet implemented")
    }

    override fun removeFavoriteTvShow(tvShow: TvShow) {
        TODO("Not yet implemented")
    }

    override fun isFavoriteTvShow(tvShow: TvShow): Boolean {
        TODO("Not yet implemented")
    }
}


