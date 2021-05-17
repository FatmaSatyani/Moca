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

    @Query("SELECT * FROM favorite_movie_data")
    fun getFavoriteMovie(): DataSource.Factory<Int, FavoriteMovieData>

    @Query("SELECT * FROM favorite_movie_data WHERE id = :id ")
    fun getFavoriteMovieById(id: Int): FavoriteMovieData?

    @Insert(onConflict = REPLACE)
    fun addFavoriteMovie(favoriteMovie: FavoriteMovieData)

    @Query("DELETE FROM favorite_movie_data WHERE id =:id")
    fun removeFavoriteMovie(id: Int)
}