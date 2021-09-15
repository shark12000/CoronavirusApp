package com.example.coronaway.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coronaway.data.room.dao.CountryDao
import com.example.coronaway.data.room.dao.DataDao
import com.example.coronaway.data.room.dao.InfoDao
import com.example.coronaway.data.room.entities.CountryEntity
import com.example.coronaway.data.room.entities.DataEntity
import com.example.coronaway.data.room.entities.InfoEntity
import com.example.coronaway.utils.Converters

@Database(entities = [CountryEntity::class, DataEntity::class, InfoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class CoronavirusRoomDatabase : RoomDatabase() {

    abstract fun infoDao(): InfoDao
    abstract fun dataDao(): DataDao
    abstract fun countryDao(): CountryDao

}