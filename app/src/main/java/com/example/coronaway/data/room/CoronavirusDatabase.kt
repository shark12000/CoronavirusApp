package com.example.coronaway.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coronaway.data.room.dao.CountryDao
import com.example.coronaway.data.room.dao.DataDao
import com.example.coronaway.data.room.dao.InfoDao
import com.example.coronaway.data.room.entities.CountryEntity
import com.example.coronaway.data.room.entities.DataEntity
import com.example.coronaway.data.room.entities.InfoEntity

@Database(entities = [CountryEntity::class, DataEntity::class, InfoEntity::class], version = 1)
abstract class CoronavirusRoomDatabase : RoomDatabase() {

    abstract fun infoDao(): InfoDao
    abstract fun dataDao(): DataDao
    abstract fun countryDao(): CountryDao

}