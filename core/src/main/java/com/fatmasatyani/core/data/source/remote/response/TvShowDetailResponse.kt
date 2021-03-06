//package com.fatmasatyani.core.data.source.remote.response
//
//import android.os.Parcelable
//import androidx.room.PrimaryKey
//import com.google.gson.annotations.SerializedName
//import kotlinx.parcelize.Parcelize
//
//@Parcelize
//data class TvShowDetailResponse (
//    @PrimaryKey(autoGenerate = false)
//
//    @field:SerializedName("id")
//    val id: Int = 0,
//
//    @field:SerializedName("backdrop_path")
//    val backdropPath: String = "",
//
//    @field:SerializedName("overview")
//    val overview: String = "",
//
//    @field:SerializedName("first_air_date")
//    val firstAirDate: String = "",
//
//    @field:SerializedName("vote_average")
//    val voteAverage: Float = 0f,
//
//    @field:SerializedName("name")
//    val name: String = "",
//
//    @field:SerializedName("poster_path")
//    val posterPath: String =""
//        ): Parcelable