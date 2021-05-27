package com.fatmasatyani.core.data.source

import com.fatmasatyani.core.data.source.local.LocalDataSource
import com.fatmasatyani.core.data.source.remote.response.ApiResponse
import com.fatmasatyani.core.data.source.remote.response.MovieDetailResponse
import com.fatmasatyani.core.data.source.remote.response.TvShowDetailResponse
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
import com.fatmasatyani.core.domain.model.MovieModel
import com.fatmasatyani.core.domain.model.TvShowModel
import com.fatmasatyani.core.domain.repository.IMocaRepository
import com.fatmasatyani.core.utils.DataMapper
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MovieCatalogueRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource): IMocaRepository {

    override fun getListMovie(): Flow<Resource<List<MovieModel>>> =
        object : NetworkBoundResource<List<MovieModel>, List<MovieDetailResponse>>() {
            override fun loadFromDB(): Flow<List<MovieModel>> =
                localDataSource.getAllMovies().map {
                    DataMapper.mapMovieEntitiesToDomain(it)
                }

            override fun shouldFetch(data: List<MovieModel>?): Boolean = true

            override fun createCall(): Flow<ApiResponse<List<MovieDetailResponse>>> =
                remoteDataSource.getMovie()

            override fun saveCallResult(data: List<MovieDetailResponse>) {
                val movie = DataMapper.mapMovieDetailResponsesToMovie(data)
            }

        }.asFlow()

    override fun getAllFavoriteMovie(): Flow<List<FavoriteMovieModel>> =
        localDataSource.getAllMovies().map {
            DataMapper.mapFavMovEntitiesToFavMovDomain(it)
        }

    override fun addFavoriteMovie(movie: FavoriteMovieModel) {
        CoroutineScope(Dispatchers.IO).launch {
            val favMovie = DataMapper.mapDomainToFavMovEntities(movie)
            localDataSource.addFavoriteMovie(favMovie)
        }
    }

    override fun removeFavoriteMovie(movie: FavoriteMovieModel) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.removeFavoriteMovie(movie.MovId)
        }
    }

    override fun isFavoriteMovie(movie: MovieModel): Boolean {
        return localDataSource.isFavoriteMovieById(movie)
    }

    override fun getListTvShow(): Flow<Resource<List<TvShowModel>>> =
        object : NetworkBoundResource<List<TvShowModel>, List<TvShowDetailResponse>>() {
            override fun loadFromDB(): Flow<List<TvShowModel>> =
                localDataSource.getAllTvShows().map {
                    DataMapper.mapTvShowEntitiesToDomain(it)
                }

            override fun shouldFetch(data: List<TvShowModel>?): Boolean = true

            override fun createCall(): Flow<ApiResponse<List<TvShowDetailResponse>>> =
                remoteDataSource.getTvShow()

            override fun saveCallResult(data: List<TvShowDetailResponse>) {
                val movie = DataMapper.mapTvShowDetailResponsesToTvShow(data)
            }

        }.asFlow()


    override fun getAllFavoriteTvShow(): Flow<List<FavoriteTvShowModel>> =
        localDataSource.getAllTvShows().map {
            DataMapper.mapFavTvEntitiesToFavTvDomain(it)
        }


    override fun addFavoriteTvShow(tvShow: FavoriteTvShowModel) {
        CoroutineScope(Dispatchers.IO).launch {
            val favTvShow = DataMapper.mapDomainToFavTvEntities(tvShow)
            localDataSource.addFavoriteTvShows(favTvShow)
        }
    }

    override fun removeFavoriteTvShow(tvShow: FavoriteTvShowModel) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.removeFavoriteTvShow(tvShow.tvShowId)
        }
    }

    override fun isFavoriteTvShow(tvShow: TvShowModel): Boolean {
        return localDataSource.isFavoriteTvShowById(tvShow)
    }
}

//    override fun getTvShow(id: Int): Flow<Resource<TvShow>> {
//        return object : NetworkBoundResource<TvShow, TvShowDetailResponse>() {
//            override fun loadFromDB(): Flow<TvShow> =
//                localDataSource.getTvShowById(id)
//
//            override fun shouldFetch(data: TvShow?): Boolean = true
//
//            override fun createCall(): Flow<ApiResponse<TvShowDetailResponse>> =
//                remoteDataSource.getTvShowById(id)
//
//            override fun saveCallResult(data: TvShowDetailResponse) {
//                val tvShow = TvShow(
//                    id = data.id,
//                    backdropPath = data.backdropPath,
//                    overview = data.overview,
//                    firstAirDate = data.firstAirDate,
//                    voteAverage = data.voteAverage,
//                    name = data.name,
//                    posterPath = data.posterPath
//                )
//                val tvShowList = arrayListOf<TvShow>()
//                tvShowList.add(tvShow)
//                localDataSource.insertTvShow(tvShowList)
//            }
//        }.asFlow()
//    }
//
//    override fun getAllFavoriteTvShow(): Flow<FavoriteTvShowModel> =
//        localDataSource.getFavoriteTvShows().map {
//            DataMapper.mapDomainToFavTvEntities(it)
//        }
//
//    override fun removeFavoriteTvShow(tvShow: FavoriteTvShowData) =
//        localDataSource.removeFavoriteTvShow(tvShow)
//
//    override fun addFavoriteTvShow(tvShow: FavoriteTvShowData) =
//        localDataSource.addFavoriteTvShows(DataMapper.mapDomainToFavTvEntities(tvShow))
//
//    override fun isFavoriteTvShow(tvShow: TvShow): Boolean =
//        localDataSource.isFavoriteTvShow(tvShow)
//
//    override fun isFavoriteTvShowById(tvShow: TvShow): Boolean =
//        localDataSource.isFavoriteTvShowById(tvShow)




