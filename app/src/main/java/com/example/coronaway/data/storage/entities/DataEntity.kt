package com.example.coronaway.data.storage.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coronaway.data.api.models.Country

@Entity(tableName = "data")
data class DataEntity(
        @PrimaryKey
        @ColumnInfo(name = "totalConfirmed")
        val totalConfirmed: Long?,

        @ColumnInfo(name = "totalDeaths")
        val totalDeaths: Long?,

        @ColumnInfo(name = "totalRecovered")
        val totalRecovered: Long?,
)
