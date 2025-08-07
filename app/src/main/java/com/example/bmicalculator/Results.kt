package com.example.bmicalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Results(modifier: Modifier = Modifier, viewModel: ResultsViewModel, navController: NavController,
            weight: String = "", height: String = "") {

    var resultBMI: String = stringResource(R.string.bmi_results_label)
    resultBMI = viewModel.calculateBMI(weight, height, resultBMI)

    Box(modifier = modifier) {

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Display Last Inputted Weight
            Text(
                text = stringResource(id = R.string.weight_label) + ": " + viewModel.weight.value,
                modifier = Modifier.padding(bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )


            // Display Last Inputted Height
            Text(
                text = stringResource(id = R.string.height_label) + ": " + viewModel.height.value,
                modifier = Modifier.padding(bottom = 80.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )


            // Displaying Last BMI Results
            Text(
                text = resultBMI,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(120.dp))

            // Calculate BMI Button
            Button(
                onClick = {
                    navController.navigate(Routes.parameterInputsScreen)
                    viewModel.onButtonClick()
                          },
                modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth()
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
