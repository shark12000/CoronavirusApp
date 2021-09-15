package com.example.coronaway.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coronaway.data.room.entities.InfoEntity
import com.example.coronaway.utils.models.Info
import kotlinx.coroutines.flow.Flow

@Dao
abstract class InfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(info: InfoEntity)

    @Query("DELETE FROM info")
    abstract suspend fun deleteInfo()

    @Query("SELECT * FROM info")
    abstract fun getInfo(): Flow<Info>
}