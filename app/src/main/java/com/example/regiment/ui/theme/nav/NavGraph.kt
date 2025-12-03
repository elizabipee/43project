package com.example.regiment.ui.theme.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun navGraph(
    navController:NavHostController = rememberNavController(),
    modifier: Modifier = Modifier ){
    NavHost(
        navController = navController,
        startDestination = WorkoutScreen
    ){

    }
}