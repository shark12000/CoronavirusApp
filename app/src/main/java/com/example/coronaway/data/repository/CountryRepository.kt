package com.example.coronaway.data.repository

import androidx.room.withTransaction
import com.example.coronaway.data.api.API
import com.example.coronaway.data.storage.CoronavirusRoomDatabase
import com.example.coronaway.data.storage.entities.CountryEntity
import com.example.coronaway.utils.networkBoundResource
import javax.inject.Inject

class CountryRepository @Inject constructor(private val db: CoronavirusRoomDatabase, private val api: API){
    private val country = db.countryDao()

    fun getCountry() = networkBoundResource(
        query = {
            country.getCountries()
        },
        fetch = {
            api.getResult()
        },
        saveFetchResult = {
            db.withTransaction {
                country.deleteCountries()
                country.insert(
                    country = it.china.countries.map {
                        CountryEntity(it.country, it.lat, it.exLong, it.confirmed, it.recovered, it.deaths)
                    }
                )
            }
        })
}