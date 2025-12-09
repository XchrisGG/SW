package com.example.appstresswatch.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appstresswatch.R
import com.example.appstresswatch.components.CustomPasswordTextField
import com.example.appstresswatch.components.CustomTextField
import com.example.appstresswatch.components.NavigationBar
import com.example.appstresswatch.ui.theme.StressDarkBlue
import com.example.appstresswatch.ui.theme.StressGray
import com.example.appstresswatch.viewModels.RegisterViewModel

@Composable

fun PreViewInfo(
    viewModel: RegisterViewModel,
    onBack: () -> Unit,
    onNext: () -> Unit,
    apellido: () -> Unit,
    edad: () -> Unit,
    sexo: () -> Unit,
    fecha: () -> Unit,
    pais: () -> Unit,
    correo: () -> Unit,
    ult: () -> Unit

){Scaffold(
    bottomBar = {
        NavigationBar(
            onBack = onBack,
            onNext = onNext
        )
    }
) { padding ->

    val avatarList = listOf(
        R.drawable.avatarfemenino,
        R.drawable.avatarmasculino,
        R.drawable.avatarfemenino,
        R.drawable.avatarmasculino,
        R.drawable.avatarfemenino,
        R.drawable.avatarmasculino,
        R.drawable.avatarfemenino,
        R.drawable.avatarmasculino,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StressDarkBlue)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))


        Text(
            ("Esta es tu info ${viewModel.nombre}."),
            color = StressGray,
            fontSize = 20.sp
        )

        Image(
            painter = painterResource(id = avatarList[viewModel.avatarIndex]),
            contentDescription = "Avatar seleccionado",
            modifier = Modifier
                .size(120.dp)
                .padding(top = 20.dp),
            contentScale = ContentScale.Crop
        )


        Spacer(modifier = Modifier.height(40.dp))


        Spacer(modifier = Modifier.height(40.dp))

        Text(
            "Apellido:  ${viewModel.apellido}",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
                .clickable{apellido()},
            )


        Spacer(modifier = Modifier.height(20.dp))



        Text(
            "Edad: ${viewModel.edad}",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
                .clickable{edad()},

        )
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            "Sexo: ${viewModel.sexo}",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
                .clickable{sexo()},

        )
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            "Fecha De Nacimiento:${viewModel.fechaNacimiento}",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
                .clickable{fecha()},

        )
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            "Pais: ${viewModel.pais}",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
                .clickable{pais()},

        )
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            "Correo: ${viewModel.correo}",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
                .clickable{correo()},

        )
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            "Contraseña: ${viewModel.password}",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)
                .clickable{ult()},

        )
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            "¿Algo esta mal? !No te preocupes. presiona el dato incorrecto para modificarlo",
            color = StressGray,
            fontSize = 15.sp,
        )




    }
}

}
