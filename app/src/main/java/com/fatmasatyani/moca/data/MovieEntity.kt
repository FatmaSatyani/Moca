package com.fatmasatyani.moca.data

data class MovieEntity(
        val movieId: String?,
        val movieTitle: String?,
        val movieDescription: String?,
        val movieDisplayPicture: Int,
        val movieTrailer: String?,
        val detailEntity: List<DetailEntity>
        )