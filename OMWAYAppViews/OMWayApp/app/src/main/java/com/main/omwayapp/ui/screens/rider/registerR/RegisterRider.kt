package com.main.omwayapp.ui.screens.rider.register

import android.widget.ImageButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomButtonG
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.theme.Fondo
import com.main.omwayapp.ui.theme.IBMplexSans
import com.main.omwayapp.ui.theme.TextOpacidad
import com.main.omwayapp.ui.theme.TextoGeneral

@Preview
@Composable
fun RegisterRider() {

    var text = remember {
        mutableStateOf("")
    }
    
    Surface(modifier = Modifier.fillMaxSize(), color = Fondo) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(35.dp))

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(vertical = 10.dp, horizontal = 30.dp),
                text = "Crear Cuenta",
                color = TextoGeneral,
                textAlign = TextAlign.Start,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = IBMplexSans


            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 30.dp),
                text = "Por favor llenar todos los campos.",
                color = TextOpacidad,
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = IBMplexSans


            )
            Spacer(modifier = Modifier.height(10.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    valueState = text,
                    labelId = "CIF",
                    icon = painterResource(id = R.drawable.id),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )
                Spacer(modifier = Modifier.height(7.dp))

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    valueState = text,
                    labelId = "Nombre",
                    icon = painterResource(id = R.drawable.usuario),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )
                Spacer(modifier = Modifier.height(7.dp))

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    valueState = text,
                    labelId = "Email",
                    icon = painterResource(id = R.drawable.email),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )
                Spacer(modifier = Modifier.height(7.dp))

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    valueState = text,
                    labelId = "Telefono",
                    icon = painterResource(id = R.drawable.telefono),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )

                Spacer(modifier = Modifier.height(7.dp))

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    valueState = text,
                    labelId = "Contraseña",
                    icon = painterResource(id = R.drawable.password),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )
                Spacer(modifier = Modifier.height(7.dp))

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    valueState = text,
                    labelId = "Confirmar Contraseña",
                    icon = painterResource(id = R.drawable.password),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

            }

            CustomButtonG(modifier = Modifier.width(222.dp).height(51.dp), text = "Regístrate", fontSize = 20.sp) {
                //val loginResponse = loginModel.onSummit(context)

            }

        }
        
    }
}