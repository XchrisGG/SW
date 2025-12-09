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
import com.example.appstresswatch.components.InfoCard
import com.example.appstresswatch.components.NavigationBar
import com.example.appstresswatch.ui.theme.StressDarkBlue
import com.example.appstresswatch.ui.theme.StressGray

@Composable
fun InfoScreen(
    onBack: () -> Unit,
    onNext: () -> Unit
) {

    Scaffold(
        bottomBar = {
            NavigationBar(
                onBack = onBack,
                onNext = onNext
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

            Image(
                painter = painterResource(id = R.drawable.logo_stress),
                contentDescription = "StressWatch logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(280.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                "RECUERDA QUE:",
                color = StressGray,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            InfoCard(
                text = "En caso de una situación de crisis, recuerda que la app te brinda “Ayuda” para comunicarte con una línea externa de crisis."
            )

            Spacer(modifier = Modifier.height(40.dp))

            InfoCard(
                text = "La App no busca reemplazar la terapia profesional, busca ser un complemento y ayudarte en tu recorrido."
            )

            Spacer(modifier = Modifier.height(40.dp))

            InfoCard(
                text = "La app no puede determinar un diagnóstico. Recuerda acudir siempre con un profesional de la salud."
            )
        }
    }
}
