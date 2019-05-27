package com.kalashnyk.denys.sweather.presentation.item

import android.support.v7.widget.RecyclerView
import com.kalashnyk.denys.sweather.databinding.CityItemBinding
import com.kalashnyk.denys.sweather.presentation.activities.detail.DetailActivity
import com.kalashnyk.denys.sweather.repository.database.entity.CityEntity

class CityViewHolder(private val binding: CityItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private var city: CityEntity? = null

    fun bind(city: CityEntity) {
        this.city = city
        binding.city = this.city
        binding.handler = this
    }

    fun openCityDetail() {
        binding.root.context.startActivity(DetailActivity.newInstance(binding.root.context, city!!.name))
    }
}