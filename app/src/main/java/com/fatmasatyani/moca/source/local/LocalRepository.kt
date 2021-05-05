package com.fatmasatyani.moca.source.local

import android.content.Context
import com.fatmasatyani.moca.dao.MovieDao
import com.fatmasatyani.moca.dao.TvShowDao

class LocalRepository(context: Context) {

    private val movieDao: MovieDao
    private val tvShowDao: TvShowDao

    init {
        val database = AppDatabase.getInstance(context)
        movieDao = database.movieDao()
        tvShowDao = database.tvShowDao()
    }

    companion object {
        fun getInstance(context: Context): LocalRepository {
            return LocalRepository(context)
        }
    }
}