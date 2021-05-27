package com.fatmasatyani.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowModel (
    val tvShowId: Int,
    val tvShowBackdrop: String,
    val tvShowOverview: String,
    val tvShowFirstAirDate: String,
    val tvShowVoteAverage: Float,
    val tvShowName: String,
    val tvShowPoster: String
        ) : Parcelable