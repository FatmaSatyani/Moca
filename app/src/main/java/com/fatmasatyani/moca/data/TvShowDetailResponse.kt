package com.fatmasatyani.moca.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowDetailResponse (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Float,

//        @field:SerializedName("episode_run_time")
//        val episodeRunTime: List<Int?>,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String
        ): Parcelable