package com.example.appstresswatch.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appstresswatch.ui.theme.StressMint

@Composable
fun NavigationBarMenu(
    onHome: () -> Unit,
    onChat: () -> Unit,
    onProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(StressMint)
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Home
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.clickable { onHome() }
        )

        // Chat
        Icon(
            imageVector = Icons.Default.Chat,
            contentDescription = "Chat",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.clickable { onChat() }
        )

        // Usuario
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Usuario",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.clickable { onProfile() }
        )
    }
}
