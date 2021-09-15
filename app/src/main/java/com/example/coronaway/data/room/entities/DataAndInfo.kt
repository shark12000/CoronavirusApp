package com.example.coronaway.data.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class DataAndInfo (
        @Embedded val info: InfoEntity,
        @Relation(
                parentColumn = "infoId",
                entityColumn = "infoOwnerId"
        )
        val data: DataWithCountries)

