package com.fatmasatyani.moca.source.remote.response

import android.os.Parcelable
import androidx.room.Entity
import com.fatmasatyani.moca.data.Movie
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class MovieResponse(
	@SerializedName("result")
	val result: MutableList<Movie>)

