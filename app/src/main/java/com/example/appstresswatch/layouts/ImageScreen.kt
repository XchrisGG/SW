package com.example.appstresswatch.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.appstresswatch.components.AvatarCarousel
import com.example.appstresswatch.components.CustomPasswordTextField
import com.example.appstresswatch.components.CustomTextField
import com.example.appstresswatch.components.NavigationBar
import com.example.appstresswatch.ui.theme.StressDarkBlue
import com.example.appstresswatch.ui.theme.StressGray
import com.example.appstresswatch.viewModels.RegisterViewModel

@Composable

fun ImageScreen(
    viewModel: RegisterViewModel,
    onBack: () -> Unit,
    onNext: () -> Unit


){Scaffold(
    bottomBar = {
        NavigationBar(
            onBack = onBack,
            onNext = onNext
        )
    }
)


{ padding ->

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

        Image(
            painter = painterResource(id = R.drawable.logo_stress),
            contentDescription = "StressWatch logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(280.dp)
        )


        Text(
            ("Ya casi terminamos ${viewModel.nombre}."),
            color = StressGray,
            fontSize = 20.sp
        )


        Spacer(modifier = Modifier.height(40.dp))


        Spacer(modifier = Modifier.height(40.dp))

        Text(
            "Selecciona una Imagen de perfil",
            color = StressGray,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start)

        )
        Spacer(modifier = Modifier.height(50.dp))

        AvatarCarousel(
            avatars = avatarList,
            selectedIndex = viewModel.avatarIndex,
            onAvatarSelected = { index ->
                viewModel.avatarIndex = index
            }
        )






    }
}

}