package org.chevalier.howlseye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.chevalier.howlseye.components.*
import org.chevalier.howlseye.ui.theme.Tugas2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas2Theme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Text(
                            text = "Register",
                            style = TextStyle(fontSize = 24.sp),
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text = "Daftar menggunakan username, email dan password anda",
                            style = TextStyle(fontSize = 16.sp),
                            modifier = Modifier.padding(8.dp)
                        )
                        TextBox(
                            name = "Username",
                            placeholder = "Buat Username",
                            icon = { VectorIcon(Icons.Filled.Person, "Username") },
                            onValueChange = {}
                        )
                        TextBox(
                            name = "Email",
                            placeholder = "Buat Email",
                            icon = { VectorIcon(Icons.Filled.Email, "Email") },
                            onValueChange = {}
                        )
                        TextBox(
                            name = "Password",
                            placeholder = "Buat Password",
                            icon = { VectorIcon(Icons.Filled.Lock, "Password") },
                            icon2 = {
                                Icon(
                                painter = painterResource(id = R.drawable.eye),
                                contentDescription = "Hide",
                                modifier = Modifier.size(32.dp),
                                tint = Color.Black
                            )},
                            onValueChange = {}
                        )
                        Btn(text = "Register")
                    }
                }
            }
        }
    }
}
