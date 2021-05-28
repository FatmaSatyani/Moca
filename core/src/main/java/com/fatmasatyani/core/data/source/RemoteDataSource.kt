package com.fatmasatyani.core.data.source

import com.fatmasatyani.core.constant.Constant.Companion.API_KEY
import com.fatmasatyani.core.data.source.remote.response.ApiResponse
import com.fatmasatyani.core.data.source.remote.response.MovieDetailResponse
//import com.fatmasatyani.core.data.source.remote.response.TvShowDetailResponse
import com.fatmasatyani.core.network.ApiConfig
import com.fatmasatyani.core.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    private val apiConfig = ApiConfig.getApiService()
    private val apiKey = API_KEY

//    companion object {
//        fun getInstance(): RemoteDataSource {
//            return RemoteDataSource(get())
//        }
//    }

//    fun getMovie()= flow {
//        emit(Resource.loading())
//        return flow {
//            try {
//                val response = apiConfig.popularMovie(apiKey)
//                if (response.result.isNotEmpty()) {
//                    emit(ApiResponse.Success(response.result))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//            }
//        }.flowOn(Dispatchers.IO)
//    }

    fun getMovie(): Flow<ApiResponse<List<MovieDetailResponse>>> {
        return flow {
            try {
                val response = apiService.popularMovie(apiKey)
                if (response.result.isNotEmpty()) {
                    emit(ApiResponse.Success(response.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }


//    fun getMovie (): LiveData<ApiResponse<List<MovieDetailResponse>>> {
//        val movie: MutableLiveData<ApiResponse<List<MovieDetailResponse>>> = MutableLiveData()
//        EspressoIdlingResource.increment()
//
//        apiConfig.popularMovie(API_KEY).enqueue(
//            object : Callback<MovieResponse>{
//                override fun onResponse(
//                    call: Call<MovieResponse>,
//                    response: Response<MovieResponse>
//                ) {
//                    response.body()?.let { movie.postValue(ApiResponse.success(it.result)) }
//                    EspressoIdlingResource.decrement()
//                }
//                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                }
//            }
//        )
//        return movie
//    }

    //NEW
//    fun getMovieById(): Flow<ApiResponse<List<MovieDetailResponse>>> {
//        return flow {
//            try {
//                val response = apiConfig.movie(0, API_KEY)
//                if (response.result.isNotEmpty()) {
//                    emit(ApiResponse.Success(response.result))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//            }
//        }.flowOn(Dispatchers.IO)
//    }

//    fun getMovieById(id: Int): Flow<ApiResponse<MovieDetailResponse>> {
//        return flow {
//            try {
//                val response = apiService.movie(0,API_KEY)
//                if (response.result.isNotEmpty()) {
//                    emit(ApiResponse.Success(response.result))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//            }
//        }.flowOn(Dispatchers.IO)
//    }


//    fun getMovieById(id: Int): LiveData<ApiResponse<MovieDetailResponse>> {
//        val movieById = MutableLiveData<ApiResponse<MovieDetailResponse>>()
//        EspressoIdlingResource.increment()
//
//        apiConfig.movie(id, API_KEY).enqueue(
//            object : Callback<MovieDetailResponse> {
//                override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
//                    movieById.value = ApiResponse.success(response.body() as MovieDetailResponse)
//                    EspressoIdlingResource.decrement()
//                }
//                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
//                }
//            }
//        )
//        return movieById
//    }

//    fun getTvShow(): Flow<ApiResponse<List<TvShowDetailResponse>>> {
//        return flow {
//            try {
//                val response = apiConfig.popularTvShow(API_KEY)
//                if (response.result.isNotEmpty()) {
//                    emit(ApiResponse.Success(response.result))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//            }
//        }.flowOn(Dispatchers.IO)
//    }

//    fun getTvShowById(id: Int): Flow<ApiResponse<TvShowDetailResponse>> {
//        return flow {
//            try {
//                val response = apiService.tvShow(0,API_KEY)
//                if (response.result.isNotEmpty()) {
//                    emit(ApiResponse.Success(response.result))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//            }
//        }.flowOn(Dispatchers.IO)
//    }

//    fun getTvShow (): LiveData<ApiResponse<List<TvShowDetailResponse>>> {
//        val tvShow: MutableLiveData<ApiResponse<List<TvShowDetailResponse>>> = MutableLiveData()
//        EspressoIdlingResource.increment()
//
//        apiConfig.popularTvShow(API_KEY).enqueue(
//            object : Callback<TvResponse>{
//                override fun onResponse(
//                    call: Call<TvResponse>,
//                    response: Response<TvResponse>
//                ) {
//                    response.body()?.let { tvShow.postValue(ApiResponse.success(it.result)) }
//                    EspressoIdlingResource.decrement()
//                }
//                override fun onFailure(call: Call<TvResponse>, t: Throwable) {
//                }
//            }
//        )
//        return tvShow
//    }
//
//        override fun getTvShowById(id:Int) : LiveData<ApiResponse<TvShowDetailResponse>> {
//        val tvShowById: MutableLiveData<ApiResponse<TvShowDetailResponse>> = MutableLiveData()
//        EspressoIdlingResource.increment()
//
//        apiConfig.tvShow(id, API_KEY).enqueue(
//            object : Callback<TvShowDetailResponse> {
//                override fun onResponse(call: Call<TvShowDetailResponse>, response: Response<TvShowDetailResponse>) {
//                    tvShowById.postValue(ApiResponse.success(response.body() as TvShowDetailResponse))
//                    EspressoIdlingResource.decrement()
//                }
//                override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
//                }
//            }
//        )
//        return tvShowById
//    }
}






