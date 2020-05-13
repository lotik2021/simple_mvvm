package com.lotik2021.simplemvvm.data.db.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.lotik2021.simplemvvm.data.db.dao.SimpleDao
import com.lotik2021.simplemvvm.data.model.Simple
import javax.inject.Inject

class DbRepository @Inject internal constructor(
    private val simpleDao: SimpleDao
) {

    fun simpleById(id: Int): LiveData<Simple> {
        return simpleDao.simpleById(id)
    }

    fun simpleAll(): LiveData<List<Simple>> {
        return simpleDao.simpleAll()
    }

    @WorkerThread
    suspend fun addSimple(simple: Simple) {
        simpleDao.addSimple(simple)
    }
}