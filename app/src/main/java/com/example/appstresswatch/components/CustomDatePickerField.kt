package com.example.appstresswatch.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appstresswatch.ui.theme.StressMint
import java.util.Calendar

@Composable
fun CustomDatePickerField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    TextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .clickable {
                // Crear calendario con fecha actual
                val calendar = Calendar.getInstance()
                val datePickerDialog = DatePickerDialog(
                    context,
                    { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                        val selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
                        onValueChange(selectedDate)
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                datePickerDialog.show()
            },
        shape = RoundedCornerShape(
            topStart = 22.dp,
            topEnd = 22.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            unfocusedContainerColor = StressMint,
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true
    )
}
