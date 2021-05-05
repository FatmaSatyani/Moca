package com.fatmasatyani.moca.source.local

import android.content.Context
import androidx.room.*
import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import com.fatmasatyani.moca.dao.MovieDao
import com.fatmasatyani.moca.dao.TvShowDao

@Database (
    entities = [MovieResponse::class, TvResponse::class],
    version = 2,
    exportSchema = false
        )
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun tvShowDao() : TvShowDao

    companion object {
        private const val DB_NAME = "DB_MVTV"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}