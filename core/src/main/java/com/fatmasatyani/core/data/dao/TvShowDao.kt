package com.fatmasatyani.core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.fatmasatyani.core.data.entity.FavoriteTvShowData
import com.fatmasatyani.core.data.entity.TvShow
import com.fatmasatyani.core.domain.model.FavoriteTvShowModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDao {

    @Query("SELECT * FROM TvShow")
    fun getList(): Flow<List<TvShow>>

    @Query("SELECT * FROM TvShow WHERE id = :id")
    fun getTvShowById(id: Int) : Flow<TvShow>

    @Insert(onConflict = REPLACE)
    fun insert(tvShow: List<TvShow>)

    @Query("SELECT * FROM favorite_tv_Show_data")
    fun getFavoriteTvShow(): Flow<FavoriteTvShowData>

    @Query("SELECT * FROM favorite_tv_Show_data WHERE id= :id")
    fun getFavoriteTvShowById(id: Int): FavoriteTvShowData?

    @Insert(onConflict = REPLACE)
    fun addFavoriteTvShow(favoriteTvShow: FavoriteTvShowData)

    @Query("DELETE FROM favorite_tv_Show_data WHERE id= :id")
    fun removeFavoriteTvShow(id: Int)
}