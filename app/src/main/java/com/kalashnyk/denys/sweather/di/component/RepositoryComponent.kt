package com.kalashnyk.denys.sweather.di.component

import com.kalashnyk.denys.sweather.di.module.RepositoryModule
import com.kalashnyk.denys.sweather.di.scope.RepositoryScope
import com.kalashnyk.denys.sweather.repository.AppRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repository: AppRepository
}