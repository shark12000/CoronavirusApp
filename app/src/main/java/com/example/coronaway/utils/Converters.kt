package com.example.coronaway.utils

import androidx.room.TypeConverter
import com.example.coronaway.utils.models.Country
import com.example.coronaway.utils.models.Data
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromListToString(list: List<Country>) = Gson().toJson(list)!!

    @TypeConverter
    fun fromObjectToString(data: Data) = Gson().toJson(data)!!

    @TypeConverter
    fun fromStringToList(string: String) = Gson().fromJson(string, Array<Country>::class.java).toList()

    @TypeConverter
    fun fromStringToObject(string: String) = Gson().fromJson(string, Data::class.java)!!
}