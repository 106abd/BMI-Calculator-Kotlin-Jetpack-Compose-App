package com.example.bmicalculator.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class BMISchema(

    @PrimaryKey
    val entryNo: Int = 0,
    var date: Date,
    var height: String,
    var weight: String,
    var bmi: String

)