package com.example.regiment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.regiment.ui.theme.RegimentTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.regiment.viewmodel.WorkoutViewModel
import com.example.regiment.ui.theme.nav.navGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegimentTheme {
                val workoutViewModel: WorkoutViewModel = viewModel()
                   navGraph(viewModel= workoutViewModel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    RegimentTheme {
//        WorkoutScreen(viewModel = WorkoutViewModel())

    }
}
