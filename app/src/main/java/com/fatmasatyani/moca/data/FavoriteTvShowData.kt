package com.fatmasatyani.moca.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorite_tv_Show_data",
    primaryKeys = ["favoriteTvShowId", "id"],
    foreignKeys = [ForeignKey(entity = TvShow::class,
        parentColumns = ["id"],
        childColumns = ["id"])],
    indices = [Index(value = ["favoriteTvShowId"]), Index(value = ["id"])])
data class FavoriteTvShowData(
    @NonNull
    @ColumnInfo(name = "favoriteTvShowId")
    var favoriteId: String,

    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @NonNull
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,

    @NonNull
    @ColumnInfo(name = "overview")
    val overview: String,

    @NonNull
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,

    @NonNull
    @ColumnInfo(name = "vote_average")
    val voteAverage: Float,

    @NonNull
    @ColumnInfo(name = "name")
    val name: String,

    @NonNull
    @ColumnInfo(name = "poster_path")
    val posterPath: String
    )