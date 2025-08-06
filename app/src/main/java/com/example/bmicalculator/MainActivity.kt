package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view models
        val resultsViewModel = ViewModelProvider(this)[ResultsViewModel::class.java]
        val parameterInputsViewModel = ViewModelProvider(this)[ParameterInputsViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            BMICalculatorTheme {

                // Initialize Navigation Controller
                val navController = rememberNavController()

                // Provides padding values to ensure android OS UI doesn't overlap
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // Provides routes for different screens
                    NavHost(navController = navController, startDestination = Routes.resultsScreen, builder = {

                        // Results.kt Screen
                        composable(route = Routes.resultsScreen) {
                            Results(
                                modifier = Modifier.padding(innerPadding),
                                viewModel = resultsViewModel,
                                navController = navController
                            )}


                        // ParameterInputs.kt Screen
                        composable(route = Routes.parameterInputsScreen) {
                            ParameterInputs(
                                modifier = Modifier.padding(innerPadding),
                                viewModel = parameterInputsViewModel,
                                navController = navController
                            )
                        }
                    })
                }
            }
        }
    }
}
