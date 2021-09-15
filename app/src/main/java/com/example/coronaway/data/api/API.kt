package com.example.coronaway.data.api

import com.example.coronaway.utils.models.Info
import retrofit2.http.GET
import retrofit2.http.Headers

interface API {
    @Headers("Vary1:dfgfdsg4358ou9h48ihkdsjfhds")
    @GET(".")
    suspend fun getResult(): Info
}