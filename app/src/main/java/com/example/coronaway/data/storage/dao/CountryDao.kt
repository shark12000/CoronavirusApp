package com.example.coronaway.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coronaway.data.storage.entities.CountryEntity
import com.example.coronaway.view.models.Country
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(country: List<CountryEntity>)

    @Query("DELETE FROM country")
    abstract suspend fun deleteCountries()

    @Query("SELECT * FROM country GROUP BY name")
    abstract fun getCountries(): Flow<List<Country>>
}