package com.fatmasatyani.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavoriteMovieModel (
    val favId: Int,
    val MovId: Int,
    val backdrop: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Float,
    val runtime: Int,
    val title: String,
    val poster: String
        ) : Parcelable