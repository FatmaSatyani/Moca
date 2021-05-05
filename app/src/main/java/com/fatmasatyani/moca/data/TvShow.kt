package com.fatmasatyani.moca.data

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "TvShow")
data class TvShow(

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("backdrop_path")
        val backdropPath: String,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("first_air_date")
        val firstAirDate: String,

        @field:SerializedName("vote_average")
        val voteAverage: Float,

        @field:SerializedName("episode_run_time")
        val episodeRunTime: List<Int?>,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("poster_path")
        val posterPath: String
) : Parcelable
