package com.example.bmicalculator

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ParameterInputsViewModel : ViewModel() {
    private val _weight = mutableStateOf("")
    val weight: State<String> get() = _weight

    private val _height = mutableStateOf("")
    val height: State<String> get() = _height

    private val _validInputEvent = MutableSharedFlow<Boolean>()
    val validInputEvent = _validInputEvent.asSharedFlow()


    // Calculate BMI Event Function
    fun onButtonClick() {
        Log.i("Button Clicked", "")

        val weightValue = _weight.value.toDoubleOrNull();
        val heightValue = _height.value.toDoubleOrNull();

        if (weightValue != null && heightValue != null && heightValue > 0) {
            viewModelScope.launch { _validInputEvent.emit(true) }
        } else {
            viewModelScope.launch { _validInputEvent.emit(false) }
        }
    }

    // Updating weight input field
    fun onWeightChange(newWeight: String) {
        val isValidNum = newWeight.toDoubleOrNull()

        if (isValidNum != null || newWeight == "") {
            _weight.value = newWeight
            Log.i("New Weight", _weight.value)
        }


    }

    // Updating height input field
    fun onHeightChange(newHeight: String) {
        val isValidNum = newHeight.toDoubleOrNull()

        if (isValidNum != null || newHeight == "") {
            _height.value = newHeight
            Log.i("New Height", _height.value)
        }
    }

}