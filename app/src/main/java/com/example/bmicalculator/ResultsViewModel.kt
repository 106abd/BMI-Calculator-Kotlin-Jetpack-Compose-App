package com.example.bmicalculator

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ResultsViewModel : ViewModel() {

    private val _height = mutableStateOf("")
    val height: State<String> get() = _height

    private val _weight = mutableStateOf("")
    val weight: State<String> get() = _weight


    // Calculate BMI Event Function
    fun onButtonClick() {
        Log.i("Button Clicked", "")
    }

    fun calculateBMI(inputWeight: String, inputHeight: String, defaultMsg: String) : String {

        val weightValue = inputWeight.toDoubleOrNull()
        val heightValue = inputHeight.toDoubleOrNull()

        if (weightValue != null && heightValue !== null && heightValue > 0) {

            _weight.value = "$inputWeight kg"
            _height.value = "$inputHeight m"
            val bmi = "Your BMI: " + (weightValue / (heightValue * heightValue)).toString()
            return bmi

        } else {
            return defaultMsg
        }
    }

}