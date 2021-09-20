package com.example.coronaway.data.repository

import androidx.room.withTransaction
import com.example.coronaway.data.api.API
import com.example.coronaway.data.storage.CoronavirusRoomDatabase
import com.example.coronaway.data.storage.entities.CountryEntity
import com.example.coronaway.data.storage.entities.DataEntity
import com.example.coronaway.utils.networkBoundResource
import javax.inject.Inject

class DataRepository @Inject constructor(private val db: CoronavirusRoomDatabase, private val api: API){
    private val data = db.dataDao()

    fun getData() = networkBoundResource(
        query = {
            data.getData()
        },
        fetch = {
            api.getResult()
        },
        saveFetchResult = {
            db.withTransaction {
                data.deleteData()
                data.insert(
                    DataEntity(
                        totalDeaths = it.china.totalDeaths,
                        totalConfirmed = it.china.totalConfirmed,
                        totalRecovered = it.china.totalRecovered
                    )
                )
            }
        })



}