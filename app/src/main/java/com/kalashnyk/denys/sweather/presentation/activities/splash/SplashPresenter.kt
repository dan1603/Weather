package com.kalashnyk.denys.sweather.presentation.activities.splash

import android.annotation.SuppressLint
import android.content.Context
import com.kalashnyk.denys.sweather.R
import com.kalashnyk.denys.sweather.presentation.base.BasePresenter
import com.kalashnyk.denys.sweather.repository.AppRepository

class SplashPresenter(val repository: AppRepository) : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    @SuppressLint("CheckResult")
    override fun getDefaultCityList(context: Context) {
        repository.addDefaultCityList(getList(context))
            .subscribe({
                getView()!!.openMain()
            }, { error ->
                getView()!!.openMain()
            })

    }

    fun getList(context: Context) : List<String>{
        return context.resources.getStringArray(R.array.default_cities).toList()
    }
}