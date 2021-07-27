package com.example.coronaway.utils.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("totalConfirmed")
    val totalConfirmed: Long,

    @SerializedName("totalDeaths")
    val totalDeaths: Long,

    @SerializedName("totalRecovered")
    val totalRecovered: Long,

    @SerializedName("data")
    val countries: List<Country>
)
