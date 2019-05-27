package com.kalashnyk.denys.sweather.presentation.activities.splash

import android.content.Context
import com.kalashnyk.denys.sweather.presentation.base.BaseContract

interface SplashContract {

    interface View: BaseContract.View {
        fun openMain()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getDefaultCityList(context : Context)
    }

}