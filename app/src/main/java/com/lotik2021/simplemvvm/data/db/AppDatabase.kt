package com.lotik2021.simplemvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lotik2021.simplemvvm.data.db.dao.SimpleDao
import com.lotik2021.simplemvvm.data.model.Simple

@Database(entities = [(Simple::class)], version = 9)
abstract class AppDatabase : RoomDatabase() {

    abstract val simpleDao: SimpleDao
}