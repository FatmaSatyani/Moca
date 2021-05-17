package com.fatmasatyani.moca.source.remote

import com.fatmasatyani.moca.data.MovieDetailResponse
import com.fatmasatyani.moca.data.TvShowDetailResponse
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{id}")
    fun movie(@Path("id") id: Int, @Query("api_key") apiKey: String) : Call<MovieDetailResponse>

    @GET("movie/popular")
    fun popularMovie (@Query("api_key") apiKey: String) : Call <MovieResponse>

    @GET("tv/{id}")
    fun tvShow(@Path("id") id: Int, @Query("api_key") apiKey: String) : Call<TvShowDetailResponse>

    @GET("tv/popular")
    fun popularTvShow (@Query("api_key") apiKey: String) : Call <TvResponse>

}