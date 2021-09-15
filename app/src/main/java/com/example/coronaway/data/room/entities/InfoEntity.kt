package com.example.coronaway.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coronaway.utils.models.Data

@Entity(tableName = "info")
data class InfoEntity (
        @PrimaryKey
        @ColumnInfo(name = "lastCheckTimeMilli")
        val lastCheckTimeMilli: Long,

        @ColumnInfo(name = "lastCheckTimeText")
        val lastCheckTimeText: String,

        @ColumnInfo(name = "china")
        val data: Data
    )
