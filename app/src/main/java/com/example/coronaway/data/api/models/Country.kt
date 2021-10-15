package com.example.coronaway.data.api.models

import com.google.gson.annotations.SerializedName

data class Country(
        @SerializedName("country")
        var country: String,

        @SerializedName("lat")
        var lat: Float,

        @SerializedName("long")
        var exLong: Float,

        @SerializedName("confirmed")
        var confirmed: Long,

        @SerializedName("deaths")
        var deaths: Long,

        @SerializedName("recovered")
        var recovered: Long,
    )
