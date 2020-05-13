package com.lotik2021.simplemvvm.ui.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lotik2021.simplemvvm.data.db.repository.DbRepository
import com.lotik2021.simplemvvm.data.model.Simple
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    private val dbRepository: DbRepository
): ViewModel() {

    fun simpleById(id: Int): LiveData<Simple> {
        return dbRepository.simpleById(id)
    }

    fun simpleAll(): LiveData<List<Simple>> {
        return dbRepository.simpleAll()
    }

    fun addSimple() {
        GlobalScope.launch(Dispatchers.IO) {
            dbRepository.addSimple(Simple(null, Date().time.toString()))
        }
    }
}