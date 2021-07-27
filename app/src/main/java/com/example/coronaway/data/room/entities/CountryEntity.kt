package com.example.coronaway.data.room.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity (
        @PrimaryKey(autoGenerate = true) val countryId: Int?,

        @ColumnInfo(name = "dataId")
        val dataOwnerId: Int?,

        @ColumnInfo(name = "country")
        val country: String?,

        @ColumnInfo(name = "lat")
        val lat: Float?,

        @ColumnInfo(name = "long")
        val exLong: Float?,

        @ColumnInfo(name = "confirmed")
        val confirmed: Long?,

        @ColumnInfo(name = "deaths")
        val deaths: Long?,

        @ColumnInfo(name = "recovered")
        val recovered: Long?,
)  {
}