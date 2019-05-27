package com.kalashnyk.denys.sweather.presentation.activities.main

import com.kalashnyk.denys.sweather.presentation.base.BasePresenter
import com.kalashnyk.denys.sweather.repository.AppRepository
import com.kalashnyk.denys.sweather.utils.DataMapping

class MainPresenter(val repository: AppRepository) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun removeCity(name: String) {
        var cityEntity = DataMapping.convertStringToCity(name)
        compositeDisposable?.add(repository.removeCity(cityEntity).subscribe { getView()!!.removeCity(cityEntity) })
    }

    override fun addCity(name: String) {
        var cityEntity = DataMapping.convertStringToCity(name)
        compositeDisposable?.add(repository.addCity(cityEntity).subscribe { getView()!!.updateList(cityEntity) })
    }

    override fun getListCities() {
        compositeDisposable?.add(repository.getListCities().subscribe({
            getView()!!.showListCities(it)
        }, { error -> getView()?.showError(error.message!!)}))
    }
}