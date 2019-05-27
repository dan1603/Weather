package com.kalashnyk.denys.sweather.presentation.activities.main

import com.kalashnyk.denys.sweather.presentation.base.BaseContract
import com.kalashnyk.denys.sweather.repository.database.entity.CityEntity

interface MainContract {

    interface View: BaseContract.View {
        fun showListCities(list: List<CityEntity>)
        fun updateList(city: CityEntity)
        fun removeCity(city: CityEntity)
        fun showError(error: String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getListCities()
        fun addCity(name: String)
        fun removeCity(name: String)
    }
}