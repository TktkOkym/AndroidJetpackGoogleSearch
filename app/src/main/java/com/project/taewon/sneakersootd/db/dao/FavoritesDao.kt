package com.project.taewon.sneakersootd.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.taewon.sneakersootd.db.tables.Favorites

@Dao
interface FavoritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favorites: Favorites)

    @Delete
    fun delete(favorites: Favorites)

    @Query("SELECT * FROM favorites")
    fun loadAll(): LiveData<List<Favorites>>
}