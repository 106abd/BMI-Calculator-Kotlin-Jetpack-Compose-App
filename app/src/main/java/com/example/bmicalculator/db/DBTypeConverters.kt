package com.example.bmicalculator.db

import androidx.room.TypeConverter
import java.util.Date

class DBTypeConverters {

    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(time: Long): Date {
        return Date(time)
    }

}