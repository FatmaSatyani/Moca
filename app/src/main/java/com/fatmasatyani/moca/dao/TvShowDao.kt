package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.FavoriteTvShowData
import com.fatmasatyani.moca.data.TvShow

@Dao
interface TvShowDao {

    @Query("SELECT * FROM TvShow")
    fun getList(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM TvShow WHERE id = :id")
    fun getTvShowById(id: Int) : LiveData<TvShow>

    @Insert(onConflict = REPLACE)
    fun insert(tvShow: List<TvShow>)

    @Update
    fun update (tvShow: TvShow): Int

    @Query("SELECT * FROM favorite_tv_Show_data")
    fun getFavoriteTvShow(): DataSource.Factory<Int, FavoriteTvShowData>

    @Query("SELECT * FROM favorite_tv_Show_data")
    fun getFavoriteTvShowById(): DataSource.Factory<Int, FavoriteTvShowData>

    @Insert(onConflict = REPLACE)
    fun addFavoriteTvShow(favoriteTvShow: FavoriteTvShowData)

    @Delete
    fun removeFavoriteTvShow(favorite: FavoriteTvShowData)
}