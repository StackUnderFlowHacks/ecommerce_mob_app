package com.mrwhoknows.ecommerce_mob_app.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun HelloCompose(text: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Hello $text",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = TextUnit.Sp(28)
            )
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Button(onClick = {}, modifier = Modifier.padding(16.dp)) {
            Text(text = "A BUTTON")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Demo() {
    HelloCompose("World")
}