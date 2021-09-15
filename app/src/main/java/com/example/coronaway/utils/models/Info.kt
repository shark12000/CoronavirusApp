package com.example.coronaway.utils.models

import com.google.gson.annotations.SerializedName

data class Info(
        @SerializedName("lastCheckTimeMilli")
        val lastCheckTimeMilli: Long,

        @SerializedName("lastCheckTimeText")
        val lastCheckTimeText: String,

        @SerializedName("china")
        val data: Data
)
