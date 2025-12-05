package com.example.regiment.ui.theme.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.regiment.viewmodel.WorkoutViewModel
import com.example.regiment.ui.theme.screens.SchedulingScreen
import com.example.regiment.ui.theme.screens.WorkoutScreen


@Composable
fun navGraph(
    viewModel: WorkoutViewModel,
    modifier: Modifier = Modifier ){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WorkoutScreen
    ){
        composable(WorkoutScreen){
            WorkoutScreen(viewModel = viewModel,
                navController = navController)
        }

        composable(SchedulingScreen){
            SchedulingScreen(
navController = navController
            )
        }

    }
}