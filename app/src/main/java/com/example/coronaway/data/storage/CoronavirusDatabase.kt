package com.example.coronaway.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coronaway.data.storage.dao.CountryDao
import com.example.coronaway.data.storage.dao.DataDao
import com.example.coronaway.data.storage.entities.CountryEntity
import com.example.coronaway.data.storage.entities.DataEntity

@Database(entities = [CountryEntity::class, DataEntity::class], version = 2, exportSchema = true)
@TypeConverters(Converters::class)
abstract class CoronavirusRoomDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao
    abstract fun countryDao(): CountryDao
}