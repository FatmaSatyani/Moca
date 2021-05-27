package com.fatmasatyani.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.fatmasatyani.core.data.entity.FavoriteMovieData
import com.fatmasatyani.core.data.entity.Movie
import com.fatmasatyani.core.domain.model.FavoriteMovieModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getList(): Flow<List<Movie>>

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getMovieById(id: Int) : Flow<List<Movie>>

    @Insert(onConflict = REPLACE)
    fun insert (movie: List<Movie>)

    @Query("SELECT * FROM favorite_movie_data")
    fun getFavoriteMovie(): Flow<FavoriteMovieData>

    @Query("SELECT * FROM favorite_movie_data WHERE id = :id ")
    fun getFavoriteMovieById(id: Int): FavoriteMovieData?

    @Insert(onConflict = REPLACE)
    fun addFavoriteMovie(favoriteMovie: FavoriteMovieData)

    @Query("DELETE FROM favorite_movie_data WHERE id =:id")
    fun removeFavoriteMovie(id: Int)
}