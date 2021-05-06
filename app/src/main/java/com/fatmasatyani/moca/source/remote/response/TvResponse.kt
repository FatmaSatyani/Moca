package com.fatmasatyani.moca.source.remote.response

import com.fatmasatyani.moca.data.TvShowDetailResponse
import com.google.gson.annotations.SerializedName

data class TvResponse(
	@SerializedName("results")
	val result: MutableList<TvShowDetailResponse>)


