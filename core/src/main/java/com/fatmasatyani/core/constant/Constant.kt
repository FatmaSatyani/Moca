package com.fatmasatyani.core.constant

import com.fatmasatyani.core.BuildConfig


class Constant {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = BuildConfig.API_KEY
        const val IMG_URL = "https://image.tmdb.org/t/p/w500"
    }
}