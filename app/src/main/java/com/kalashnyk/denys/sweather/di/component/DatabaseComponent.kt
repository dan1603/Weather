package com.kalashnyk.denys.sweather.di.component

import com.kalashnyk.denys.sweather.di.module.DatabaseModule
import com.kalashnyk.denys.sweather.repository.database.AppDatabase
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}
