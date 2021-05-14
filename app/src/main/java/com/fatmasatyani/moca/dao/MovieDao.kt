package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getList(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getMovieById(id: Int) : LiveData<Movie>

    @Insert(onConflict = REPLACE)
    fun insert (movie: List<Movie>)

    @Update
    fun update(movie: Movie): Int

    @Query("SELECT * FROM favorite_movie_data")
    fun getFavoriteMovie(): DataSource.Factory<Int, FavoriteMovieData>

    @Insert(onConflict = REPLACE)
    fun addFavoriteMovie(favoriteMovie: FavoriteMovieData)

    @Delete
    fun removeFavoriteMovie(favorite: FavoriteMovieData)
}