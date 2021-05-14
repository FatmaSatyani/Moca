package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getList(): LiveData<List<Movie>>

    @Query ("SELECT * FROM Movie WHERE id = :id")
    fun getMovieById(id: Int) : LiveData<Movie>

    @Insert (onConflict = REPLACE)
    fun insert (movie: List<Movie>): Long

    @Update
    fun update (movie: Movie): Int

//    @Delete
//    fun delete (movie: Movie)

//    @Query("DELETE FROM Movie WHERE id =:id")
//    fun deleteMovieById (id:Long) : Int

    @Query("SELECT * FROM favorite_movie_data")
    fun getFavoriteMovie(): LiveData<List<FavoriteMovieData>>

    @Insert(onConflict = REPLACE)
    fun addFavoriteMovie (favoriteMovie: Movie)

//    @Query("SELECT * FROM favorite_movie_data WHERE favoriteMovieId=:favoriteMovieId")
//    fun getSingleMovieFavorite(favoriteMovieId: Int): FavoriteMovieData

    @Delete
    fun removeFavoriteMovie(favorite: Movie)
}