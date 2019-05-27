package com.kalashnyk.denys.sweather.presentation.item

import android.support.v7.widget.RecyclerView
import com.kalashnyk.denys.sweather.databinding.ItemWeatherDataForDayBinding
import com.kalashnyk.denys.sweather.repository.model.WeatherForDay

class WeatherDataForDayViewHolder(private val binding: ItemWeatherDataForDayBinding) : RecyclerView.ViewHolder(binding.root) {

    private var data: WeatherForDay? = null

    fun bind(day: WeatherForDay) {
        this.data = day
        binding.data = this.data
    }

}