package com.example.bmicalculator

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ParameterInputsViewModel : ViewModel() {
    private val _weight = mutableStateOf("")
    private val _height = mutableStateOf("")

    val weight: State<String> get() = _weight
    val height: State<String> get() = _height


    // Calculate BMI Event Function
    fun onButtonClick() {
        Log.i("Button Clicked", "")
    }

    // Updating weight input field
    fun onWeightChange(newWeight: String) {
        val isValidNum = newWeight.toDoubleOrNull()

        if (isValidNum != null) {
            _weight.value = newWeight
            Log.i("New Weight", _weight.value)
        }


    }

    // Updating height input field
    fun onHeightChange(newHeight: String) {
        val isValidNum = newHeight.toDoubleOrNull()

        if (isValidNum != null) {
            _height.value = newHeight
            Log.i("New Height", _height.value)
        }
    }

}