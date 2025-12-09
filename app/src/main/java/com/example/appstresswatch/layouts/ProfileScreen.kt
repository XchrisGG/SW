package com.example.appstresswatch.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appstresswatch.R
import com.example.appstresswatch.components.InfoCardHome
import com.example.appstresswatch.components.NavigationBarMenu
import com.example.appstresswatch.ui.theme.StressDarkBlue
import com.example.appstresswatch.ui.theme.StressGray

@Composable

fun ProfileScreen(
    onHome: () -> Unit,
    onChat: () -> Unit,
    onProfile: () -> Unit,


    ){ Scaffold(
    bottomBar = {
        NavigationBarMenu(
            onHome = onHome,
            onChat = onChat,
            onProfile = onProfile
        )
    }
) { padding ->

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StressDarkBlue)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(15.dp))

        Text(
            "Buenos dias",
            color = StressGray,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            "Monitoreo de estrés",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(20.dp))


        InfoCardHome(
            text = "Niveles de estrés",
            icon = R.drawable.menu4, // tu ícono
            onClick = {
                println("InfoCard presionado")
            }
        )

        Text(
            "Actividad Fisica",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
        )


        Spacer(modifier = Modifier.height(20.dp))

        InfoCardHome(
            text = "Nivel de actividad ",
            icon = R.drawable.menu5, // tu ícono
            onClick = {
                println("InfoCard presionado")
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            "Estado de animo",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(20.dp))


        InfoCardHome(
            text = "Niveles de temperatura corporal ",
            icon = R.drawable.menu6, // tu ícono
            onClick = {
                println("InfoCard presionado")
            }
        )
    }
}

}