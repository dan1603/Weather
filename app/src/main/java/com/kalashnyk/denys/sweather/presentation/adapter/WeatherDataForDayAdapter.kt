package com.kalashnyk.denys.sweather.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kalashnyk.denys.sweather.databinding.ItemWeatherDataForDayBinding
import com.kalashnyk.denys.sweather.presentation.base.BaseAdapter
import com.kalashnyk.denys.sweather.presentation.item.WeatherDataForDayViewHolder
import com.kalashnyk.denys.sweather.repository.model.WeatherForDay

class WeatherDataForDayAdapter(private val context: Context, private val data: ArrayList<WeatherForDay>) :
    BaseAdapter<WeatherDataForDayViewHolder, WeatherForDay>(data as MutableList<WeatherForDay>) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WeatherDataForDayViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemWeatherDataForDayBinding.inflate(inflater, p0, false)
        return WeatherDataForDayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherDataForDayViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}