package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fatmasatyani.moca.data.*
import com.fatmasatyani.moca.source.NetworkBoundResource
import com.fatmasatyani.moca.source.local.LocalDataSource
import com.fatmasatyani.moca.source.remote.response.ApiResponse
import com.fatmasatyani.moca.utils.AppExecutors
import com.fatmasatyani.moca.vo.Resource

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

        return object: NetworkBoundResource<PagedList<Movie>, List<MovieDetailResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<Movie>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localRepository.getAllMovies(),config).build()
            }

            override fun shouldFetch(data: PagedList<Movie>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieDetailResponse>>> =
                remoteRepository.getMovie()

            override fun saveCallResult(data: List<MovieDetailResponse>) {
                val movieList = mutableListOf<Movie>()
                data.forEach {
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

    override fun getMovie(id: Int): LiveData<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<Movie> =
                localRepository.getMovieById(id)

            override fun shouldFetch(data: Movie?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteRepository.getMovieById(id)

            override fun saveCallResult(data: MovieDetailResponse) {
                val movie = Movie(
                    id = data.id,
                    backdropPath = data.backdropPath,
                    overview = data.overview,
                    releaseDate = data.releaseDate,
                    voteAverage = data.voteAverage,
                    runtime = data.runtime,
                    title = data.title,
                    posterPath = data.posterPath
                )
                val movieList = arrayListOf<Movie>()
                movieList.add(movie)
                localRepository.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllFavoriteMovies(): LiveData<PagedList<FavoriteMovieData>> {
        val result = MediatorLiveData<PagedList<FavoriteMovieData>>()
        appExecutors.mainThread().execute {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            val dbSource = LivePagedListBuilder(localRepository.getFavoriteMovies(),config).build()
            result.addSource(dbSource) { newData ->
                result.value = newData
            }
        }
        return result
    }

    override fun addFavoriteMovie(movie: Movie) {
        val favoriteMovieData = FavoriteMovieData(
            0,
            movie.id ?: 0,
            movie.backdropPath ?: "",
            movie.overview ?: "",
            movie.releaseDate ?: "",
            movie.voteAverage,
            movie.runtime ?: 0,
            movie.title ?: "",
            movie.posterPath
        )
        localRepository.addFavoriteMovie(favoriteMovieData)
    }

    override fun removeFavoriteMovie(movie: Movie) {
        val favoriteMovieData = FavoriteMovieData(
            0,
            movie.id ?: 0,
            movie.backdropPath ?: "",
            movie.overview ?: "",
            movie.releaseDate ?: "",
            movie.voteAverage,
            movie.runtime ?: 0,
            movie.title ?: "",
            movie.posterPath
        )
        localRepository.removeFavoriteMovie(favoriteMovieData)
    }

    override fun isFavoriteMovie(movie: Movie): Boolean =
        localRepository.isFavoriteMovie(movie)


    override fun getListTvShows(page: Int): LiveData<Resource<PagedList<TvShow>>> {

        return object: NetworkBoundResource<PagedList<TvShow>, List<TvShowDetailResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShow>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localRepository.getAllTvShows(),config).build()
            }

            override fun shouldFetch(data: PagedList<TvShow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowDetailResponse>>> =
                remoteRepository.getTvShow()

            override fun saveCallResult(data: List<TvShowDetailResponse>) {
                val tvShowList = mutableListOf<TvShow>()
                data.forEach {
                    val tvShow = TvShow (
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
                localRepository.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getTvShow(id: Int): LiveData<Resource<TvShow>> {
        return object : NetworkBoundResource<TvShow, TvShowDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShow> =
                localRepository.getTvShowById(id)

            override fun shouldFetch(data: TvShow?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<TvShowDetailResponse>> =
                remoteRepository.getTvShowById(id)

            override fun saveCallResult(data: TvShowDetailResponse) {
                val tvShow = TvShow (
                    id = data.id,
                    backdropPath = data.backdropPath,
                    overview = data.overview,
                    firstAirDate = data.firstAirDate,
                    voteAverage = data.voteAverage,
                    name = data.name,
                    posterPath = data.posterPath
                )
                val tvShowList = arrayListOf<TvShow>()
                tvShowList.add(tvShow)
                localRepository.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }


    override fun getAllFavoriteTvShow(): LiveData<PagedList<FavoriteTvShowData>> {
        val result = MediatorLiveData<PagedList<FavoriteTvShowData>>()
        appExecutors.mainThread().execute {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            val dbSource = LivePagedListBuilder(localRepository.getFavoriteTvShows(),config).build()
            result.addSource(dbSource) { newData ->
                result.value = newData
            }
        }
        return result
    }

    override fun addFavoriteTvShow(tvShow: TvShow) {
        val favoriteTvShowData = FavoriteTvShowData (
                0,
                tvShow.id ?: 0,
                tvShow.backdropPath ?: "",
                tvShow.overview ?: "",
                tvShow.firstAirDate?: "",
                tvShow.voteAverage,
                tvShow.name?: "",
                tvShow.posterPath
            )
        localRepository.addFavoriteTvShows(favoriteTvShowData)
        }

    override fun removeFavoriteTvShow(tvShow: TvShow) {
        val favoriteTvShowData = FavoriteTvShowData (
            0,
            tvShow.id ?: 0,
            tvShow.backdropPath ?: "",
            tvShow.overview ?: "",
            tvShow.firstAirDate?: "",
            tvShow.voteAverage,
            tvShow.name?: "",
            tvShow.posterPath
        )
        localRepository.removeFavoriteTvShow(favoriteTvShowData)
    }

    override fun isFavoriteTvShow(tvShow: TvShow): Boolean =
        localRepository.isFavoriteTvShow(tvShow)

}


