package com.kalashnyk.denys.sweather.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kalashnyk.denys.sweather.databinding.CityItemBinding
import com.kalashnyk.denys.sweather.presentation.activities.main.MainActivity
import com.kalashnyk.denys.sweather.presentation.base.BaseAdapter
import com.kalashnyk.denys.sweather.presentation.item.CityViewHolder
import com.kalashnyk.denys.sweather.repository.database.entity.CityEntity

class CityAdapter(private val context: Context, private var cities: ArrayList<CityEntity>, private var removeHandler: MainActivity)
    : BaseAdapter<CityViewHolder, CityEntity>(cities as MutableList<CityEntity>) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CityViewHolder {
        val inflater = LayoutInflater.from(context)
        var binding = CityItemBinding.inflate(inflater, p0, false)
        binding.removeHandler = removeHandler
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(cities[position])
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    fun addItem(item: CityEntity) {
        cities.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(item: CityEntity) {
        cities.remove(item)
        notifyDataSetChanged()
    }
}