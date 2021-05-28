package com.fatmasatyani.core.network

//import com.fatmasatyani.core.data.source.remote.response.TvShowDetailResponse
//import com.fatmasatyani.core.data.source.remote.response.TvResponse
import com.fatmasatyani.core.data.source.remote.response.MovieDetailResponse
import com.fatmasatyani.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{id}")
    fun movie(@Path("id") id: Int, @Query("api_key") apiKey: String) : MovieDetailResponse

    @GET("movie/popular")
    fun popularMovie (@Query("api_key") apiKey: String) : MovieResponse

//    @GET("tv/{id}")
//    fun tvShow(@Path("id") id: Int, @Query("api_key") apiKey: String) : TvShowDetailResponse
//
//    @GET("tv/popular")
//    fun popularTvShow (@Query("api_key") apiKey: String) : TvResponse

}