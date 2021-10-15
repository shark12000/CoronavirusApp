package com.example.coronaway.data.api.models

import com.google.gson.annotations.SerializedName

data class Info(
        @SerializedName("lastCheckTimeMilli")
        val lastCheckTimeMilli: Long,

        @SerializedName("lastCheckTimeText")
        val lastCheckTimeText: String,

        @SerializedName("china")
        val china: Data
)
