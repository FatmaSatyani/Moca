package com.fatmasatyani.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
	@SerializedName("results")
	val result: List<MovieDetailResponse>
	)

