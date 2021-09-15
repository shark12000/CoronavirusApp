package com.example.coronaway.data.repository

import androidx.room.withTransaction
import com.example.coronaway.data.api.API
import com.example.coronaway.data.room.CoronavirusRoomDatabase
import com.example.coronaway.data.room.entities.CountryEntity
import com.example.coronaway.data.room.entities.DataEntity
import com.example.coronaway.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class CountryRepository @Inject constructor(private val db: CoronavirusRoomDatabase, private val api: API) {

    private val countryDao = db.countryDao()

    fun getData() = networkBoundResource(
            query = {
                countryDao.getCountries()
            },
            fetch = {
                delay(2000)
                api.getResult().data.countries
            },
            saveFetchResult = {
                db.withTransaction {
                    countryDao.deleteCountries()

                }
            })
}