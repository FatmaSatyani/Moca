package com.fatmasatyani.moca.source.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fatmasatyani.moca.BuildConfig
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.MovieDetailResponse
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.data.TvShowDetailResponse
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import com.fatmasatyani.moca.utils.Constant.Companion.API_KEY
import com.fatmasatyani.moca.utils.EspressoIdlingResouce
import kotlinx.coroutines.handleCoroutineException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    private val apiConfig = ApiConfig.getApiService()
    private val TAG = RemoteRepository::class.java.toString()

    companion object {
        fun getInstance(): RemoteRepository {
            return RemoteRepository()
        }
    }

    fun getMovie (): LiveData<List<MovieDetailResponse>> {
        val movie: MutableLiveData<List<MovieDetailResponse>> = MutableLiveData()
        EspressoIdlingResouce.increment()

        apiConfig.popularMovie("$API_KEY").enqueue(
            object : Callback<MovieResponse>{
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    Log.d("RepositoryCheck",response.body()?.result.toString())
                    response.body()?.let { movie.postValue(it.result) }
                    EspressoIdlingResouce.decrement()
                }
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }
            }
        )
        return movie
    }

    fun getMovieById(id: Int): LiveData<Movie> {
        val movieById: MutableLiveData<Movie> = MutableLiveData()
        EspressoIdlingResouce.increment()

        apiConfig.movie(id,"$API_KEY").enqueue(
            object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    movieById.postValue(response.body())
                    EspressoIdlingResouce.decrement()
                }
                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }
            }
        )
        return movieById
    }

    fun getTvShow (): LiveData<List<TvShowDetailResponse>> {
        val tvShow: MutableLiveData<List<TvShowDetailResponse>> = MutableLiveData()
        EspressoIdlingResouce.increment()

        apiConfig.popularTvShow("$API_KEY").enqueue(
            object : Callback<TvResponse>{
                override fun onResponse(
                    call: Call<TvResponse>,
                    response: Response<TvResponse>
                ) {
                    response.body()?.let { tvShow.postValue(it.result) }
                    EspressoIdlingResouce.decrement()
                }
                override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }
            }
        )
        return tvShow
    }

    fun getTvShowById(id:Int) : LiveData<TvShow> {
        val tvShowById: MutableLiveData<TvShow> = MutableLiveData()
        EspressoIdlingResouce.increment()

        apiConfig.tvShow(id,"$API_KEY").enqueue(
            object : Callback<TvShow> {
                override fun onResponse(call: Call<TvShow>, response: Response<TvShow>) {
                    tvShowById.postValue(response.body())
                    EspressoIdlingResouce.decrement()
                }
                override fun onFailure(call: Call<TvShow>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }
            }
        )
        return tvShowById
    }
}






