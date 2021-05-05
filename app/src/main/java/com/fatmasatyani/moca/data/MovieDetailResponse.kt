package com.fatmasatyani.moca.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieDetailResponse (
    @PrimaryKey(autoGenerate = false)

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Float,

    @ColumnInfo(name = "runtime")
    val runtime: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "poster_path")
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