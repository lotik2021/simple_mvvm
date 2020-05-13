package com.lotik2021.simplemvvm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lotik2021.simplemvvm.data.model.Simple

@Dao
abstract class SimpleDao {

    @Query("""
           SELECT * 
             FROM simple 
            WHERE id = :id
           """)
    abstract fun simpleById(id: Int): LiveData<Simple>

    @Query("""
           SELECT * 
             FROM simple 
           """)
    abstract fun simpleAll(): LiveData<List<Simple>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addSimple(song: Simple)
}