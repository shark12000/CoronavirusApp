package com.example.coronaway.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity (
        @ColumnInfo(name = "name")
        @PrimaryKey
        val name: String,

        @ColumnInfo(name = "lat")
        val lat: Float,

        @ColumnInfo(name = "exLong")
        val exLong: Float,

        @ColumnInfo(name = "confirmed")
        val confirmed: Long,

        @ColumnInfo(name = "deaths")
        val deaths: Long,

        @ColumnInfo(name = "recovered")
        val recovered: Long,
)  {
}