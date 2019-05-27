package com.kalashnyk.denys.sweather

import android.app.Application
import android.arch.persistence.room.Room
import com.kalashnyk.denys.sweather.di.component.*
import com.kalashnyk.denys.sweather.di.module.ApiModule
import com.kalashnyk.denys.sweather.di.module.DatabaseModule
import com.kalashnyk.denys.sweather.di.module.PresenterModule
import com.kalashnyk.denys.sweather.di.module.RepositoryModule
import com.kalashnyk.denys.sweather.repository.database.AppDatabase

class App: Application() {

    private var presenterComponent: PresenterComponent? = null
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this!!.database!!))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        presenterComponent = DaggerPresenterComponent.builder()
            .repositoryComponent(repositoryComponent)
            .presenterModule(PresenterModule())
            .build()
    }

    fun getPresenterComponent(): PresenterComponent {
        return this!!.presenterComponent!!
    }
}