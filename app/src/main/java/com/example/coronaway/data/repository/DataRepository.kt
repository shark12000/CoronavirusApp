package com.example.coronaway.data.repository

import androidx.room.withTransaction
import com.example.coronaway.data.api.API
import com.example.coronaway.data.room.CoronavirusRoomDatabase
import com.example.coronaway.data.room.entities.DataEntity
import com.example.coronaway.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class DataRepository@Inject constructor(private val db: CoronavirusRoomDatabase, private val api: API) {

    private val dataDao = db.dataDao()

    fun getData() = networkBoundResource(
            query = {
                dataDao.getData()
            },
            fetch = {
                delay(2000)
                api.getResult().data
            },
            saveFetchResult = {
                db.withTransaction {
                    dataDao.deleteData()
                    dataDao.insert(DataEntity(
                            dataId = null,
                            infoOwnerId = null,
                            totalConfirmed = it.totalConfirmed,
                            totalDeaths = it.totalDeaths,
                            totalRecovered = it.totalRecovered
                    )
                    )
                }
            }
    )
}