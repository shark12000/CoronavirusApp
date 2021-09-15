package com.example.coronaway.data.room.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class DataEntity(
        @PrimaryKey(autoGenerate = true) val dataId: Long?,

        val infoOwnerId: Long?,

        @ColumnInfo(name = "totalConfirmed")
        val totalConfirmed: Long?,

        @ColumnInfo(name = "totalDeaths")
        val totalDeaths: Long?,

        @ColumnInfo(name = "totalRecovered")
        val totalRecovered: Long?,
)  {
}
