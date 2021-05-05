package com.fatmasatyani.moca.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieDetailResponse (
    @PrimaryKey(autoGenerate = false)

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("vote_average")
    val voteAverage: Float,

    @field:SerializedName("runtime")
    val runtime: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String
        ):Parcelable

//@Parcelize
//@Entity(tableName = "Movie")
//data class Movie (
//    @PrimaryKey(autoGenerate = false)
//
//    @field:SerializedName("id")
//    val id: Int,
//
//    @field:SerializedName("backdrop_path")
//    val backdropPath: String,
//
//    @field:SerializedName("overview")
//    val overview: String,
//
//    @field:SerializedName("release_date")
//    val releaseDate: String,
//
//    @field:SerializedName("vote_average")
//    val voteAverage: Float,
//
//    @field:SerializedName("runtime")
//    val runtime: Int,
//
//    @field:SerializedName("title")
//    val title: String,
//
//    @field:SerializedName("poster_path")
//    val posterPath: String
//) : Parcelable