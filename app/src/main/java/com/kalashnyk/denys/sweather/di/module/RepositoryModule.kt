package com.kalashnyk.denys.sweather.di.module

import com.kalashnyk.denys.sweather.di.scope.RepositoryScope
import com.kalashnyk.denys.sweather.repository.AppRepository
import com.kalashnyk.denys.sweather.repository.database.AppDatabase
import com.kalashnyk.denys.sweather.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesRepository(communicator: ServerCommunicator, database: AppDatabase): AppRepository {
        return AppRepository(communicator, database)
    }
}