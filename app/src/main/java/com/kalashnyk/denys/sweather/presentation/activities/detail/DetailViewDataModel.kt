package com.kalashnyk.denys.sweather.presentation.activities.detail

import android.databinding.*
import com.kalashnyk.denys.sweather.repository.model.WeatherData
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.kalashnyk.denys.sweather.R
import com.kalashnyk.denys.sweather.databinding.WeatherDataBinding

class DetailViewDataModel(items: List<WeatherData>) : BaseObservable() {

    @Bindable
    var listItems: List<WeatherData> = items

    companion object {
        @JvmStatic
        @BindingAdapter("weatherItems")
        fun bindWeatherItem(viewGroup: LinearLayout, data: DetailViewDataModel) {
            if (data != null) {
                val inflater = LayoutInflater.from(viewGroup.context)
                for (weatherForDay in data.listItems) {
                    var weatherItem = DataBindingUtil.inflate<WeatherDataBinding>(inflater, R.layout.item_weather_data, viewGroup, false)
                    weatherItem.weather = weatherForDay
                    viewGroup.addView(weatherItem.root)
                }
            }
        }
    }

}
