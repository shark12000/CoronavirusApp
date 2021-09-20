package com.example.coronaway.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coronaway.data.storage.entities.DataEntity
import com.example.coronaway.view.models.Data
import kotlinx.coroutines.flow.Flow

@Dao
abstract class DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: DataEntity)

    @Query("DELETE FROM data")
    abstract suspend fun deleteData()

    @Query("SELECT * FROM data")
    abstract fun getData(): Flow<Data>
}