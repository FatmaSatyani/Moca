package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fatmasatyani.moca.source.remote.response.MovieResponse

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getList(): LiveData<List<MovieResponse>>

//    @Query ( "SELECT * FROM Movie")
//    fun getPopularPaged(): DataSource.Factory<Int, MovieResponse>

    @Query ("SELECT * FROM Movie WHERE id = :id")
    fun getMovieById(id: Int) : MovieResponse

    @Insert (onConflict = REPLACE)
    fun insert (movie: MovieResponse): Long

    @Update
    fun update (movie: MovieResponse): Int

    @Delete
    fun delete (movie: MovieResponse)

    @Query("DELETE FROM Movie WHERE id =:id")
    fun deleteMovieById (id:Long) : Int
}