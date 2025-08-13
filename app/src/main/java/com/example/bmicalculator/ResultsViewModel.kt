package com.example.bmicalculator

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmicalculator.db.BMISchema
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ResultsViewModel : ViewModel() {

    // Get Dao interface from initialized db in main application
    private val bmiDao = MainApplication.bmiDB.getBMIDao()

    // Create StateFlow variable
    val bmiData = bmiDao.getData()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)


    // Calculate BMI Event Function
    fun onButtonClick() {
        Log.i("Button Clicked", "")
        Log.i("Results", bmiData.value.toString())
    }

    // Function that updates the database if a height and weight value were passed as parameters
    fun updateParameters(inputWeight: String, inputHeight: String) {

        val weightValue = inputWeight.toDoubleOrNull()
        val heightValue = inputHeight.toDoubleOrNull()

        if (weightValue != null && heightValue != null && heightValue > 0) {
            val bmiValue = calculateBMI(inputWeight = weightValue, inputHeight = heightValue)

            val bmiParameters = BMISchema(
                date = Date.from(Instant.now()),
                weight = inputWeight,
                height = inputHeight,
                bmi = bmiValue
            )

            if(bmiData.value != null) {
                viewModelScope.launch(Dispatchers.IO) {
                    bmiDao.updateData(bmiData = bmiParameters)
                }
            } else {
                viewModelScope.launch(Dispatchers.IO) {
                    bmiDao.insertData(bmiData = bmiParameters)
                }
            }
        }
    }

    fun calculateBMI(inputWeight: Double, inputHeight: Double) : String {
            val bmi = (inputWeight / (inputHeight * inputHeight)).toString()
            return bmi
    }

}