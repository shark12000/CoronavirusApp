package com.example.coronaway.data.repository

import androidx.room.withTransaction
import com.example.coronaway.data.api.API
import com.example.coronaway.data.room.CoronavirusRoomDatabase
import com.example.coronaway.data.room.entities.InfoEntity
import com.example.coronaway.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class InfoRepository @Inject constructor(private val db: CoronavirusRoomDatabase, private val api: API) {

    private val infoDao = db.infoDao()

    fun getInfo() = networkBoundResource(
        query = {
            infoDao.getInfo()
        },
        fetch = {
            delay(2000)
            api.getResult()
        },
        saveFetchResult = {
            db.withTransaction {
                infoDao.deleteInfo()
                infoDao.insert(InfoEntity(
                        infoId = null,
                        lastCheckTimeText = it.lastCheckTimeText,
                        lastCheckTimeMilli = it.lastCheckTimeMilli
                )
                )
            }
        }
    )

}