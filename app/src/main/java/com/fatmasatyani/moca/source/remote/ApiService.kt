package com.fatmasatyani.moca.source.remote

import com.fatmasatyani.moca.BuildConfig.API_KEY
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @GET("movie/{id}")
    fun movie(@Path("id") id: Int, @Query("api_key") apiKey: String) : Call<Movie>

    @GET("movie/popular")
    fun popularMovie (@Query("api_key") apiKey: String) : Call <MovieResponse>

    @GET("tv/{id}")
    fun tvShow(@Path("id") id: Int, @Query("api_key") apiKey: String) : Call<TvShow>

    @GET("tv/popular")
    fun popularTvShow (@Query("api_key") apiKey: String) : Call <TvResponse>

}