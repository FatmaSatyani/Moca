package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
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

    @Query("SELECT * FROM favorite_tv_Show_data")
    fun getFavoriteTvShow(): DataSource.Factory<Int, FavoriteTvShowData>

    @Query("SELECT * FROM favorite_tv_Show_data WHERE id= :id")
    fun getFavoriteTvShowById(id: Int): FavoriteTvShowData?

    @Insert(onConflict = REPLACE)
    fun addFavoriteTvShow(favoriteTvShow: FavoriteTvShowData)

    @Query("DELETE FROM favorite_tv_Show_data WHERE id= :id")
    fun removeFavoriteTvShow(id: Int)
}