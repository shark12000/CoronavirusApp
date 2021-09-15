package com.example.coronaway.data.room.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "info")
data class InfoEntity (
        @PrimaryKey(autoGenerate = true) val infoId: Long?,

        @ColumnInfo(name = "lastCheckTimeMilli")
        val lastCheckTimeMilli: Long?,

        @ColumnInfo(name = "lastCheckTimeText")
        val lastCheckTimeText: String?,

    )  {
}
