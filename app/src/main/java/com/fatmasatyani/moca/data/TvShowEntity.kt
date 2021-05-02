package com.fatmasatyani.moca.data

data class TvShowEntity(
        val tvShowId: String,
        val tvShowTitle: String?,
        val tvShowDescription: String?,
        val tvShowDisplayPicture: Int,
        val tvShowTrailer: String?,
        val detailEntity: List<DetailEntity>
        )
