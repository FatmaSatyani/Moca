package com.fatmasatyani.moca.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import com.fatmasatyani.moca.utils.EspressoIdlingResouce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

//    private val apiConfig = ApiConfig.getApiService().create(ApiService::class.java)
    private val apiConfig = ApiConfig.getApiService()
    private val TAG = RemoteRepository::class.java.toString()

    companion object {
        fun getInstance(): RemoteRepository {
            return RemoteRepository()
        }
    }

    fun getMovie (page:Int): LiveData<List<Movie>> {
        val movie: MutableLiveData<List<Movie>> = MutableLiveData()
        EspressoIdlingResouce.increment()

        apiConfig.popularMovie(page).enqueue(
            object : Callback<MovieResponse>{
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
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

        apiConfig.movie(id).enqueue(
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

    fun getTvShow (page:Int): LiveData<List<TvShow>> {
        val tvShow: MutableLiveData<List<TvShow>> = MutableLiveData()
        EspressoIdlingResouce.increment()

        apiConfig.popularTvShow(page).enqueue(
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

        apiConfig.tvShow(id).enqueue(
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





