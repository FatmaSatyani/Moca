package com.fatmasatyani.moca.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fatmasatyani.moca.data.FavoriteTvShowData
import com.fatmasatyani.moca.data.TvShow

@Dao
interface TvShowDao {

    @Query("SELECT * FROM TvShow")
    fun getList(): LiveData<List<TvShow>>

    @Query("SELECT * FROM TvShow WHERE id = :id")
    fun getTvShowById(id: Int) : TvShow

    @Insert(onConflict = REPLACE)
    fun insert (tvShow: List<TvShow>): Long

    @Update
    fun update (tvShow: TvShow): Int

//    @Delete
//    fun delete (tvShow: TvShow)
//
//    @Query("DELETE FROM TvShow WHERE id =:id")
//    fun deleteTvShowById (id:Long) : Int

    @Query("SELECT * FROM favorite_tv_Show_data")
    fun getFavoriteTvShow(): LiveData<List<FavoriteTvShowData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavoriteTvShow (favoriteTvShow: TvShow)

//    @Query("SELECT * FROM favorite_tv_Show_data WHERE favoriteTvShowId=:favoriteTvShowId")
//    fun getSingleTvShowFavorite(favoriteTvShowId: Int): FavoriteTvShowData

    @Delete
    fun removeFavoriteTvShow(favorite: Int)
}