package com.example.appstresswatch.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import com.example.appstresswatch.ui.theme.StressMint

@Composable
fun InfoCardHome(
    text: String,
    icon: Int,           // recurso drawable
    onClick: () -> Unit, // callback clickeable
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = StressMint,
                shape = RoundedCornerShape(25.dp)
            )
            .clickable { onClick() } // ahora es clickeable
            .padding(horizontal = 20.dp, vertical = 18.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            // Imagen a la izquierda
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp)
            )

            // Texto a la derecha
            Text(
                text = text,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
