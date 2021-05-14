package com.fatmasatyani.moca.data

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "favorite_tv_Show_data",
        foreignKeys = [ForeignKey(entity = TvShow::class,
        parentColumns = ["id"],
        childColumns = ["id"])],
        indices = [Index(value = ["favoriteTvShowId"]), Index(value = ["id"])])
data class FavoriteTvShowData(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favoriteTvShowId")
    var favoriteId: Int,

    @NonNull
    @ColumnInfo(name = "id")
    val tvShowId: Int,

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
    val posterPath: String?
    )