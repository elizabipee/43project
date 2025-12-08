package com.example.regiment.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.regiment.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchedulingScreen(navController: NavHostController) {
    val state = rememberDatePickerState()
    val openDialog = remember {mutableStateOf(false)}

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.schedule_title)) },
                colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Return to home"
                    )
                }
            }
            )
        }
    )
    { padding ->


        Column (modifier = Modifier.padding(padding), horizontalAlignment = Alignment.CenterHorizontally){

            DatePicker(
                state = state,
                showModeToggle = true,
                title = {
                    Text("Select Workout Date",
                    modifier = Modifier.padding(20.dp))
                }
            )
            Button(onClick = {
                openDialog.value = true })
            { Text("Assign Workout") }

            if(openDialog.value){
                BasicAlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    }
                ){
                    Surface {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text =
                                    "Ok, workout scheduled for \n${state.selectedDateMillis.let{DatePickerDefaults.dateFormatter().formatDate(it,
                                        locale = Locale.current.platformLocale
                                    )}}")
                            Spacer(modifier = Modifier.height(24.dp))
                            TextButton(
                                onClick = { openDialog.value = false },
                                modifier = Modifier.align(Alignment.End)
                            ) {
                                Text("Confirm")
                            }
                        }
                    }
                }
            }
//
        //
        //            TODO("Section for selecting the type of workout scheduled")
//            TODO("Moving it all to a vm ;-; ")
        }

    }
}

@Preview
@Composable
fun SchedulingScreenPreview(){
    SchedulingScreen(navController = rememberNavController())
}

