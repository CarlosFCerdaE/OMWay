package com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.screens.driver.mycars.MyUI
import com.main.omwayapp.ui.screens.driver.navigationDriver.DriverScreens

//@Preview(showSystemUi = true)
@Composable
fun MisCarros(navController: NavController? = null){
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.fondo))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomDivider( modifier = Modifier.height(21.dp),)
        Spacer(modifier = Modifier.height(15.dp))

        if (navController!=null) {
            AgregarCarroText(navController)
        }
        Spacer(modifier = Modifier.height(15.dp))
        if(navController!=null) {
            MisCarrosOptionMenuBox(
                navController,
                marca = "Toyota",
                modelo = "Hilux",
                anio = "2020",
                tonocolor = "Gris",
                placa = "M 489753"
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisCarrosOptionMenuBox(
    navController: NavController,
    marca: String,
    modelo: String,
    anio: String,
    tonocolor: String,
    placa: String
) {
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
                    MyUI(navController,coloricono = colorResource(id = R.color.texto_general))
                }

            }
        }
    }
    }

@Composable
fun AgregarCarroText(navController: NavController){
    Row(horizontalArrangement = Arrangement.End
    ) {
        Text(text = "Agregar Carro",
            modifier = Modifier
                .clickable { navController.navigate(route = DriverScreens.AgregarCarro.route) },
            color = colorResource(id = R.color.menta_importante),
        )
    }
}