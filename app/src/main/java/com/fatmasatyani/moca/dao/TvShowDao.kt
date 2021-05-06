package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.source.remote.response.TvResponse

@Dao
interface TvShowDao {

    @Query("SELECT * FROM TvShow")
    fun getList(): LiveData<List<TvShow>>

    @Query("SELECT * FROM TvShow WHERE id = :id")
    fun getTvShowById(id: Int) : TvShow

    @Insert(onConflict = REPLACE)
    fun insert (tvShow: TvShow): Long

    @Update
    fun update (tvShow: TvShow): Int

    @Delete
    fun delete (tvShow: TvShow)

    @Query("DELETE FROM TvShow WHERE id =:id")
    fun deleteTvShowById (id:Long) : Int
}