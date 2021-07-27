package com.example.coronaway.data.room.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coronaway.data.room.entities.CountryEntity
import com.example.coronaway.utils.models.Country
import kotlinx.coroutines.flow.Flow

abstract class CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(country: CountryEntity)

    @Query("DELETE FROM country")
    abstract suspend fun deleteCountries()

    @Query("SELECT * FROM country")
    abstract fun getCountries(): Flow<List<Country>>
}