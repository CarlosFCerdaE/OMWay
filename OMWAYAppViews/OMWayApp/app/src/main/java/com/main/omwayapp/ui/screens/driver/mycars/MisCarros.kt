package com.main.omwayapp.ui.screens.driver.mycars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomDivider

@OptIn(ExperimentalMaterialApi::class)
@Preview(showSystemUi = true)
@Composable
fun listMisCarros(){
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.fondo))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Active",
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 5.dp, horizontal = 165.dp)
        )

        val checkedState = remember {
            mutableStateOf(true)
        }
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = SwitchDefaults.colors(Color.Green)
        )

        CustomDivider( modifier = Modifier.height(21.dp),)
        Spacer(modifier = Modifier.height(15.dp))
        MisCarrosOptionMenuBox(
            marca = "Toyota",
            modelo = "Hilux",
            anio = "2020",
            tonocolor = "Gris",
            placa = "M 489753"
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisCarrosOptionMenuBox(
    marca: String,
    modelo: String,
    anio: String,
    tonocolor: String,
    placa: String
) {

    val selectedText = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Box(
            modifier = Modifier
                .size(width = 330.dp, height = 75.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = colorResource(id = R.color.txt_fields))
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.carro),
                        contentDescription = "Carro",
                        tint = colorResource(id = R.color.texto_general),
                        modifier = Modifier
                            .size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = marca + " " + modelo + " " + anio,
                            color = colorResource(id = R.color.texto_general),
                            fontSize = 18.sp
                        )
                        Text(
                            text = tonocolor + " " + placa,
                            color = colorResource(id = R.color.texto_general),
                            fontSize = 18.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(45.dp))
                    MyUI(coloricono = colorResource(id = R.color.texto_general))
                }

            }
        }
    }
    }
