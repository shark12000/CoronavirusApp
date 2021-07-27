package com.example.coronaway.utils.models

import com.google.gson.annotations.SerializedName

data class Country(
        @SerializedName("country")
        val country: String,

        @SerializedName("lat")
        val lat: Float,

        @SerializedName("long")
        val exLong: Float,

        @SerializedName("confirmed")
        val confirmed: Long,

        @SerializedName("deaths")
        val deaths: Long,

        @SerializedName("recovered")
        val recovered: Long,
    )
