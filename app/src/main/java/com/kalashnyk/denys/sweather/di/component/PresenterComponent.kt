package com.kalashnyk.denys.sweather.di.component

import com.kalashnyk.denys.sweather.di.module.PresenterModule
import com.kalashnyk.denys.sweather.di.scope.PresenterScope
import com.kalashnyk.denys.sweather.presentation.activities.detail.DetailActivity
import com.kalashnyk.denys.sweather.presentation.activities.main.MainActivity
import com.kalashnyk.denys.sweather.presentation.activities.splash.SplashActivity
import dagger.Component

@PresenterScope
@Component(modules = [PresenterModule::class], dependencies = [RepositoryComponent::class])
interface PresenterComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)
    fun inject(activity: DetailActivity)
}