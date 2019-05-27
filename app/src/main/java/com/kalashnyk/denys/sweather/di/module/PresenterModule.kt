package com.kalashnyk.denys.sweather.di.module

import com.kalashnyk.denys.sweather.di.scope.PresenterScope
import com.kalashnyk.denys.sweather.presentation.activities.detail.DetailContract
import com.kalashnyk.denys.sweather.presentation.activities.detail.DetailPresenter
import com.kalashnyk.denys.sweather.presentation.activities.main.MainContract
import com.kalashnyk.denys.sweather.presentation.activities.main.MainPresenter
import com.kalashnyk.denys.sweather.presentation.activities.splash.SplashContract
import com.kalashnyk.denys.sweather.presentation.activities.splash.SplashPresenter
import com.kalashnyk.denys.sweather.repository.AppRepository
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    @PresenterScope
    internal fun provideMainPresenter(repository: AppRepository): MainContract.Presenter {
        return MainPresenter(repository)
    }

    @Provides
    @PresenterScope
    internal fun provideSplashPresenter(repository: AppRepository): SplashContract.Presenter {
        return SplashPresenter(repository)
    }

    @Provides
    @PresenterScope
    internal fun provideDetailPresenter(repository: AppRepository): DetailContract.Presenter {
        return DetailPresenter(repository)
    }
}