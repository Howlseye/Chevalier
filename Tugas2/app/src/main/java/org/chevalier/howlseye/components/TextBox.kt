package org.chevalier.howlseye.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBox(
    modifier: Modifier = Modifier,
    name: String,
    placeholder: String,
    icon: @Composable (() -> Unit)? = null,
    icon2: @Composable (() -> Unit)? = null,
    onValueChange: (value: String) -> Unit,
) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        OutlinedTextField(
            modifier =
                Modifier.fillMaxWidth().
                border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = icon,
            trailingIcon = icon2,
            placeholder = { Text(text = placeholder) },
            value = "",
            onValueChange = onValueChange,
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Transparent)
        )
    }
}

@Composable
fun VectorIcon(
    icon: ImageVector,
    description: String
){
    Icon(
        imageVector =  icon,
        contentDescription = description,
        modifier = Modifier.size(32.dp),
        tint = Color.Black
    )
}

@Preview
@Composable
private fun TextBoxPreview() {
    Surface {
        TextBox(
            name = "rawr",
            placeholder = "rawr",
            icon = { VectorIcon(Icons.Filled.Person, "Person") },
            onValueChange = {}
        )
    }
}