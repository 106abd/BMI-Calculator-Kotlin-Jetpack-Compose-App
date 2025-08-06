package com.example.bmicalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ParameterInputs(modifier: Modifier = Modifier, viewModel: ParameterInputsViewModel, navController: NavController) {

    val inputtedWeight by viewModel.weight
    val inputtedHeight by viewModel.height


    // Navigation handler
    LaunchedEffect(Unit) {

        viewModel.validInputEvent.collect { isInputValid ->
            if (isInputValid) {
                navController.navigate(Routes.resultsScreen)
            }
        }
    }


    Box(modifier = modifier) {

        Column (
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            // Weight Input Field
            OutlinedTextField(
                modifier = Modifier.padding(bottom = 20.dp),
                value = inputtedWeight,
                onValueChange = { newWeight -> viewModel.onWeightChange(newWeight) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                label = { Text(stringResource(id = R.string.weight_label)) }
            )

            // Height Input Field
            OutlinedTextField(
                modifier = Modifier.padding(bottom = 80.dp),
                value = inputtedHeight,
                onValueChange = { newWeight -> viewModel.onHeightChange(newWeight) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                label = { Text(stringResource(id = R.string.height_label)) }
            )

            // Calculate BMI Button
            Button(
                onClick = {
                    viewModel.onButtonClick()
                },
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 80.dp).fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.calculate_button_label),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

        }
    }
}