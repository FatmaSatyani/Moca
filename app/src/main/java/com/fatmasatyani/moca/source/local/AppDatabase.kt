package com.fatmasatyani.moca.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fatmasatyani.moca.dao.MovieDao
import com.fatmasatyani.moca.dao.TvShowDao
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow

@Database (
    entities = [Movie::class, TvShow::class],
    version = 2,
    exportSchema = false
        )
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