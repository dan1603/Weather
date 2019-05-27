package com.kalashnyk.denys.sweather.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kalashnyk.denys.sweather.repository.database.dao.*
import com.kalashnyk.denys.sweather.repository.database.entity.*

@Database(entities = [CityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}