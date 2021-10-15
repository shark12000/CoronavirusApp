package com.example.coronaway.view.models

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Country (
        @SerializedName("name")
        val name: String,

        @SerializedName("lat")
        val lat: Float,

        @SerializedName("exLong")
        val exLong: Float,

        @SerializedName("confirmed")
        val confirmed: Long,

        @SerializedName("deaths")
        val deaths: Long,

        @SerializedName("recovered")
        val recovered: Long,
)