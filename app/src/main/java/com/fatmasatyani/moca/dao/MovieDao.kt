package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.source.remote.response.MovieResponse

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getList(): LiveData<List<Movie>>

    @Query ("SELECT * FROM Movie WHERE id = :id")
    fun getMovieById(id: Int) : Movie

    @Insert (onConflict = REPLACE)
    fun insert (movie: Movie): Long

    @Update
    fun update (movie: Movie): Int

    @Delete
    fun delete (movie: Movie)

    @Query("DELETE FROM Movie WHERE id =:id")
    fun deleteMovieById (id:Long) : Int
}