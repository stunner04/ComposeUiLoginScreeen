package com.example.composeloginscreeninit

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.text.font.FontWeight
import com.example.composeloginscreeninit.ui.theme.Black
import com.example.composeloginscreeninit.ui.theme.focusedTextFieldText
import com.example.composeloginscreeninit.ui.theme.textFieldContainer
import com.example.composeloginscreeninit.ui.theme.unFocusedTextFieldText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String
) {
    val uiColorTheme = if (isSystemInDarkTheme()) Color.White else Black

    TextField(
        modifier = modifier,
        value = "",
        onValueChange = {},
        label = {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColorTheme)
        },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedLabelColor = MaterialTheme.colorScheme.unFocusedTextFieldText,
            focusedLabelColor = MaterialTheme.colorScheme.focusedTextFieldText,
            containerColor = MaterialTheme.colorScheme.textFieldContainer,
        ),
        trailingIcon = {
            TextButton(
                onClick = {},
            ) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColorTheme
                )
            }
        }
    )

}