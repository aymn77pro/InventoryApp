package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItmeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(itme: Item)

    @Update
    suspend fun update(itme: Item)

    @Delete
    suspend fun delete(itme: Item)

    @Query("SELECT * from item ORDER BY name ASC")
    fun getAll():Flow<List<Item>>

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int):Flow<Item>
}