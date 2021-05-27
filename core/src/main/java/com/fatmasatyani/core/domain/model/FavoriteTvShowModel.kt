package com.fatmasatyani.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavoriteTvShowModel (
    val favId: Int,
    val tvShowId: Int,
    val backdrop: String,
    val overview: String,
    val firstAirDate: String,
    val voteAverage: Float,
    val name: String,
    val poster: String
        ) : Parcelable