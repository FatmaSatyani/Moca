package com.fatmasatyani.moca.source.remote.response

import com.fatmasatyani.moca.data.MovieDetailResponse
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MovieResponse(
	@SerializedName("results")
	val result: MutableList<MovieDetailResponse>)

