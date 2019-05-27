package com.kalashnyk.denys.sweather.repository.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "city")
data class CityEntity(
    @PrimaryKey
    @SerializedName("name")
    val name: String
)