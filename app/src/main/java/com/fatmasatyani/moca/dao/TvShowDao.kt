package com.fatmasatyani.moca.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fatmasatyani.moca.source.remote.response.TvResponse

@Dao
interface TvShowDao {

    @Query("SELECT * FROM TvShow")
    fun getList(): LiveData<List<TvResponse>>

//    @Query ( "SELECT * FROM TvShow")
//    fun getPopularPaged(): DataSource.Factory<Int, TvResponse>

    @Query("SELECT * FROM TvShow WHERE id = :id")
    fun getTvShowById(id: Int) : TvResponse

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (tvShow: TvResponse): Long

    @Update
    fun update (tvShow: TvResponse): Int

    @Delete
    fun delete (tvShow: TvResponse)

    @Query("DELETE FROM TvShow WHERE id =:id")
    fun deleteTvShowById (id:Long) : Int
}