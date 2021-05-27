package com.fatmasatyani.core.data.entity

import androidx.annotation.NonNull
import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorite_movie_data",
        foreignKeys = [ForeignKey(entity = Movie::class,
        parentColumns = ["id"],
        childColumns = ["id"])],
        indices = [Index(value = ["favoriteMovieId"]), Index(value = ["id"])])
data class FavoriteMovieData(
   @NonNull
   @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "favoriteMovieId")
   var favoriteId: Int,

   @NonNull
   @ColumnInfo(name = "id")
   var movieId: Int,

   @NonNull
   @ColumnInfo(name = "backdrop_path")
   var backdropPath: String,

   @NonNull
   @ColumnInfo(name = "overview")
   var overview: String,

   @NonNull
   @ColumnInfo(name = "release_date")
   var releaseDate: String,

   @NonNull
   @ColumnInfo(name = "vote_average")
   var voteAverage: Float,

   @NonNull
   @ColumnInfo(name = "runtime")
   var runtime: Int,

   @NonNull
   @ColumnInfo(name = "title")
   var title: String,

   @field:SerializedName("poster_path")
   val posterPath: String

)