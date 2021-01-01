package com.mrwhoknows.ecommerce_mob_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hello(text = "Geeks", baseContext)
        }
    }
}

@Composable
fun Hello(text: String, context: Context) {
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
        Button(onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.padding(16.dp)) {
            Text(text = "A BUTTON")
        }
    }
}