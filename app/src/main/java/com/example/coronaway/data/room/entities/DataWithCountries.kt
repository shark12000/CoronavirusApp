package com.example.coronaway.data.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
data class DataWithCountries (
        @Embedded val data: DataEntity,
        @Relation(
                parentColumn = "dataId",
                entityColumn = "dataOwnerId"
        )
        val countries: List<CountryEntity>
)
