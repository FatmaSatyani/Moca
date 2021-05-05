package com.fatmasatyani.moca.source.remote.response

import com.fatmasatyani.moca.data.TvShowDetailResponse
import com.google.gson.annotations.SerializedName

data class TvResponse(
//	@PrimaryKey(autoGenerate = false)
	@SerializedName("result")
	val result: MutableList<TvShowDetailResponse>)


