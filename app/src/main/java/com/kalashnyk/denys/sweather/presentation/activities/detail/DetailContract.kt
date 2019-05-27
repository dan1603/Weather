package com.kalashnyk.denys.sweather.presentation.activities.detail

import com.kalashnyk.denys.sweather.presentation.base.BaseContract
import com.kalashnyk.denys.sweather.repository.model.WeatherData

interface DetailContract {

    // Only for handling error or empty state
    enum class ContentState { EMPTY, ERROR }

    interface View: BaseContract.View {
        fun showContent(list: List<WeatherData>)
        fun handlingEmptyOrErrorState(state : DetailContract.ContentState, error: String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getForecastByCityName(name: String)
    }
}