package com.fatmasatyani.moca.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fatmasatyani.moca.data.MovieDetailResponse
import com.fatmasatyani.moca.data.TvShowDetailResponse
import com.fatmasatyani.moca.source.remote.response.ApiResponse
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import com.fatmasatyani.moca.utils.Constant.Companion.API_KEY
import com.fatmasatyani.moca.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    private val apiConfig = ApiConfig.getApiService()

    companion object {
        fun getInstance(): RemoteDataSource {
            return RemoteDataSource()
        }
    }

    fun getMovie (): LiveData<List<MovieDetailResponse>> {
        val movie: MutableLiveData<List<MovieDetailResponse>> = MutableLiveData()
        EspressoIdlingResource.increment()

        apiConfig.popularMovie(API_KEY).enqueue(
            object : Callback<MovieResponse>{
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.let { movie.postValue(it.result) }
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                }
            }
        )
        return movie
    }

    fun getMovieById(id: Int): LiveData<ApiResponse<MovieDetailResponse>> {
        val movieById = MutableLiveData<ApiResponse<MovieDetailResponse>>()
//        val movieById: MutableLiveData<MovieDetailResponse> = MutableLiveData()
        EspressoIdlingResource.increment()

        apiConfig.movie(id, API_KEY).enqueue(
            object : Callback<MovieDetailResponse> {
                override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                    movieById.value = ApiResponse.success(response.body() as MovieDetailResponse)
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                }
            }
        )
        return movieById
    }

    fun getTvShow (): LiveData<List<TvShowDetailResponse>> {
        val tvShow: MutableLiveData<List<TvShowDetailResponse>> = MutableLiveData()
        EspressoIdlingResource.increment()

        apiConfig.popularTvShow(API_KEY).enqueue(
            object : Callback<TvResponse>{
                override fun onResponse(
                    call: Call<TvResponse>,
                    response: Response<TvResponse>
                ) {
                    response.body()?.let { tvShow.postValue(it.result) }
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                }
            }
        )
        return tvShow
    }

    fun getTvShowById(id:Int) : LiveData<TvShowDetailResponse> {
        val tvShowById: MutableLiveData<TvShowDetailResponse> = MutableLiveData()
        EspressoIdlingResource.increment()

        apiConfig.tvShow(id, API_KEY).enqueue(
            object : Callback<TvShowDetailResponse> {
                override fun onResponse(call: Call<TvShowDetailResponse>, response: Response<TvShowDetailResponse>) {
                    tvShowById.postValue(response.body())
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                }
            }
        )
        return tvShowById
    }
}






