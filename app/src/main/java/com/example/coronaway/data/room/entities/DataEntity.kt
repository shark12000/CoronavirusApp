package com.example.coronaway.data.room.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coronaway.utils.models.Country

@Entity(tableName = "data")
data class DataEntity(
        @PrimaryKey(autoGenerate = true) val dataId: Long?,

        @ColumnInfo(name = "totalConfirmed")
        val totalConfirmed: Long?,

        @ColumnInfo(name = "totalDeaths")
        val totalDeaths: Long?,

        @ColumnInfo(name = "totalRecovered")
        val totalRecovered: Long?,

        @ColumnInfo(name = "countries")
        val country:  List<Country>?
)  {
}
