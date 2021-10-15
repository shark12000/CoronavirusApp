package com.example.coronaway.view.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("totalConfirmed")
    val totalConfirmed: Long,

    @SerializedName("totalDeaths")
    val totalDeaths: Long,

    @SerializedName("totalRecovered")
    val totalRecovered: Long,
)
