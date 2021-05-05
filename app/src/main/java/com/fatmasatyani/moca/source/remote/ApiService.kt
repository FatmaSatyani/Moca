package com.fatmasatyani.moca.source.remote

import com.fatmasatyani.moca.BuildConfig.API_KEY
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @GET("movie/{id}?Authorization = $API_KEY")
//    @Headers("Authorization: ${API_KEY}")
    fun movie(@Path("id") id: Int) : Call<Movie>

    @GET("movie/popular?Authorization = $API_KEY")
//    @Headers("Authorization: ${API_KEY}")
    fun popularMovie (@Query("page") page: Int) : Call <MovieResponse>

    @GET("tv/{id}?Authorization = $API_KEY")
//    @Headers("Authorization: ${API_KEY}")
    fun tvShow(@Path("id") id: Int) : Call<TvShow>

    @GET("tv/popular?Authorization = $API_KEY")
//    @Headers("Authorization: ${API_KEY}")
    fun popularTvShow (@Query("page") page: Int) : Call <TvResponse>

}