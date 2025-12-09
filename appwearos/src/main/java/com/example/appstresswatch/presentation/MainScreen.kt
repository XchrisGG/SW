package com.example.appstresswatch.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*

@Composable
fun MainScreen(
    startService: () -> Unit,
    stopService: () -> Unit
) {
    Scaffold {
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Button(onClick = startService) {
                Text("Iniciar sensores")
            }

            Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

            Button(onClick = stopService) {
                Text("Detener sensores")
            }
        }
    }
}
