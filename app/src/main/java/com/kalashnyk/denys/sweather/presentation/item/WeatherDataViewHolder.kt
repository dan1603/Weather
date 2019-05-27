package com.kalashnyk.denys.sweather.presentation.item

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kalashnyk.denys.sweather.databinding.WeatherDataBinding
import com.kalashnyk.denys.sweather.presentation.adapter.WeatherDataForDayAdapter
import com.kalashnyk.denys.sweather.repository.model.WeatherData
import java.util.ArrayList

class WeatherDataViewHolder(private val binding: WeatherDataBinding): RecyclerView.ViewHolder(binding.root) {

    private var weather: WeatherData? = null

    fun bind(weather: WeatherData) {
        this.weather = weather
        binding.weather = this.weather
        initList()
    }

    private fun initList() {
        binding.rvData.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvData.adapter = WeatherDataForDayAdapter(binding.root.context, ArrayList(weather?.list))
    }
}