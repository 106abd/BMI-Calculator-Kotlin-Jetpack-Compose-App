package com.example.bmicalculator.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BMIDao {

    @Insert
    suspend fun insertData(bmiData: BMISchema)

    @Update
    suspend fun updateData(bmiData: BMISchema)

    @Query("SELECT * FROM BMISchema")
    fun getData(): Flow<BMISchema?>

}