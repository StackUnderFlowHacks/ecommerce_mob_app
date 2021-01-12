package com.mrwhoknows.ecommerce_mob_app.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun LoginForm(
    userName: String,
    password: String,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: (String, String) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(50.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = {
                onUsernameChanged(it)
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            label = { Text("Username") },
            singleLine = true
        )
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                onPasswordChanged(it)
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            label = { Text("Password") },
            singleLine = true
        )
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onClick = { onLoginClicked(userName, password) }) {
            Text(text = "LOGIN", style = TextStyle(fontSize = TextUnit.Sp(18)))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginForm(
        userName = "WhoKnows",
        password = "Password",
        onUsernameChanged = {},
        onPasswordChanged = {},
        onLoginClicked = { _, _ -> }
    )
}