package com.fatmasatyani.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel (
    val movieId: Int,
    val movieBackdrop: String,
    val movieOverview: String,
    val movieRelease: String,
    val movieVoteAverage: Float,
    val movieRunTime: Int,
    val movieTitle: String,
    val moviePoster: String
        ) : Parcelable