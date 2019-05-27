package com.kalashnyk.denys.sweather.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kalashnyk.denys.sweather.databinding.WeatherDataBinding
import com.kalashnyk.denys.sweather.presentation.base.BaseAdapter
import com.kalashnyk.denys.sweather.presentation.item.WeatherDataViewHolder
import com.kalashnyk.denys.sweather.repository.model.WeatherData

class WeatherAdapter(private val context: Context, private var weather: ArrayList<WeatherData>)
    : BaseAdapter<WeatherDataViewHolder, WeatherData>(weather as MutableList<WeatherData>) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WeatherDataViewHolder {
        val inflater = LayoutInflater.from(context)
        var binding = WeatherDataBinding.inflate(inflater, p0, false)
        return WeatherDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherDataViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(weather[position])
    }

    override fun getItemCount(): Int {
        return weather.count()
    }
}