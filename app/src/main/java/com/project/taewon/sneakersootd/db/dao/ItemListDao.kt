package com.project.taewon.sneakersootd.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

import com.project.taewon.sneakersootd.db.tables.ImageItem

@Dao
interface ItemListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: ImageItem)

    @Delete
    fun delete(item: ImageItem)

    @Query("SELECT * FROM sneakers_item")
    fun getAllSneakers(): LiveData<List<ImageItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<ImageItem>)
}