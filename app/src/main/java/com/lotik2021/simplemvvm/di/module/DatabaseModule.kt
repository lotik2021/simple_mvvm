package com.lotik2021.simplemvvm.di.module

import android.app.Application
import androidx.room.Room
import com.lotik2021.simplemvvm.data.db.AppDatabase
import com.lotik2021.simplemvvm.data.db.dao.SimpleDao
import com.lotik2021.simplemvvm.data.db.repository.DbRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideSongDao(appDatabase: AppDatabase): SimpleDao {
        return appDatabase.simpleDao
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(simpleDao: SimpleDao): DbRepository {
        return DbRepository(simpleDao)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "simple.db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}