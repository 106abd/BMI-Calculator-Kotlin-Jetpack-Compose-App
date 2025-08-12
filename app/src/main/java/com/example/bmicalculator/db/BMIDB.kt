package com.example.bmicalculator.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BMISchema::class], version = 1)
@TypeConverters(DBTypeConverters::class)
abstract class BMIDB : RoomDatabase() {

    companion object {
        val bmiDBName = "BMI_DB"
    }

    abstract fun getBMIDao(): BMIDao

}