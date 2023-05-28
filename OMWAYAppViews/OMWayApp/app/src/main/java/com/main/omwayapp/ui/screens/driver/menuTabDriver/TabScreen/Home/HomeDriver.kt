package com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.Home


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
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.screens.driver.navigationDriver.DriverScreens


@Composable
//@Preview(showSystemUi = true)
fun HomeDriver(navController: NavController? = null) {

    Column(modifier =
    Modifier
        .background(color = colorResource(id = R.color.fondo))
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomDivider( modifier = Modifier.height(21.dp),)

        Spacer(modifier = Modifier.padding(2.dp))
        Column(modifier = Modifier.align(Alignment.Start))
        {
            Spacer(modifier = Modifier.padding(4.dp))
            BienvenidoText()
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Tú Resumen:",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            )

        }

        Column(horizontalAlignment = Alignment.CenterHorizontally){

            Row(modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.Center)
            {

                TripSummary()
                GananciasSummary()

            }

            RatingDriver()


        }

        Spacer(modifier = Modifier.padding(12.dp))

        DepositoText()

        Spacer(modifier = Modifier.padding(12.dp))

        Column(){
            Row(modifier = Modifier
                .align(Alignment.Start)
                .padding(10.dp))
            {
            Box(
                modifier = Modifier
                    .height(85.dp)
                    .width(150.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                if (navController != null) {
                    AjustesBox(navController)
                }
            }

            Box(
                modifier = Modifier
                    .height(85.dp)
                    .width(150.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                ModoPasajeroBox()
                }
            }
        }



    }


}


@Composable
fun BienvenidoText(){

    var text by remember { mutableStateOf("DriverName!") }
    Row(){

        Column(){
            Text(
                text = "Bienvenido," + text,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            )
        }
        IconButton(onClick = {/*TODO*/}){
            Icon(painter = painterResource(id = R.drawable.usuario_perfil),
                contentDescription = "Usuario perfil",
                tint = Color.White,
                modifier = Modifier
                    .size(190.dp))
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripSummary(){

    var text by remember { mutableStateOf("30") }

    Column(
        modifier = Modifier
            .padding(10.dp)//,

    ) {

      TextField(value = text, onValueChange = {text=it},
          readOnly = true,
          modifier = Modifier
              .size(width = 155.dp, height = 90.dp)
              .clip(RoundedCornerShape(12.dp)),
          colors = TextFieldDefaults.textFieldColors
              (containerColor = colorResource(id = R.color.menta_importante)
          ),
          textStyle= TextStyle(fontSize=24.sp,color=colorResource(
              id = R.color.fondo),fontFamily = FontFamily(Font(R.font.imbplexsans_medium)),
              textAlign = TextAlign.Center
          ),
          label = {
              androidx.compose.material3.Text(
                  text = "Viajes",
                  fontSize = 11.sp,
                  fontFamily = FontFamily(Font(R.font.ibmplexsans_bold)),
                  color = colorResource(id = R.color.fondo),
                  textAlign = TextAlign.Start
              )
          },
      )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GananciasSummary(){


    var text by remember { mutableStateOf("C$1500") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)//,
     //   horizontalAlignment = Alignment.Start
    ) {

        TextField(value = text, onValueChange = {text=it},
            readOnly = true,
            modifier = Modifier
                .size(width = 155.dp, height = 95.dp)
                .clip(RoundedCornerShape(12.dp)),
            colors = TextFieldDefaults.textFieldColors
                (containerColor = colorResource(id = R.color.menta_importante)
            ),
            textStyle= TextStyle(fontSize=24.sp,color=colorResource(
                id = R.color.fondo),fontFamily = FontFamily(Font(R.font.imbplexsans_medium)),
                textAlign = TextAlign.Center
            ),
            label = {
                androidx.compose.material3.Text(
                    text = "Total C$",
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.ibmplexsans_bold)),
                    color = colorResource(id = R.color.fondo),
                    textAlign = TextAlign.Start
                )
            },
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingDriver(){


    var text by remember { mutableStateOf("5.0") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = text, onValueChange = {text=it},
            readOnly = true,
            modifier = Modifier
                .size(width = 155.dp, height = 95.dp)
                .clip(RoundedCornerShape(12.dp)),
            colors = TextFieldDefaults.textFieldColors
                (containerColor = colorResource(id = R.color.menta_importante)
            ),
            textStyle= TextStyle(fontSize=24.sp,color=colorResource(
                id = R.color.fondo),fontFamily = FontFamily(Font(R.font.imbplexsans_medium)),
                textAlign = TextAlign.Center
            ),
            label = {
                androidx.compose.material3.Text(
                    text = "Rating",
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.ibmplexsans_bold)),
                    color = colorResource(id = R.color.fondo),
                    textAlign = TextAlign.Center
                )
            },
            trailingIcon = {
                IconButton(onClick = {/*TODO*/}){
                    Icon(painter = painterResource(id = R.drawable.favorito),
                        contentDescription = "Rating",
                        tint = Color.Yellow,
                        modifier = Modifier
                            .size(30.dp))
                }
            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun DepositoText() {

    var text by remember { mutableStateOf("240") }
    var textDeposito by remember { mutableStateOf("Del total de tus ganancias, debes depositar: C$") }

    textDeposito = textDeposito+text;

    Column(){

        TextField(
            value = textDeposito, onValueChange = { textDeposito = it },
            readOnly = true,
            modifier = Modifier
                .size(width = 311.dp, height = 90.dp),
            colors = TextFieldDefaults.textFieldColors
                (
                containerColor = colorResource(id = R.color.fondo)
            ),
            textStyle = TextStyle(
                fontSize = 20.sp, color = colorResource(
                    id = R.color.texto_general
                ), fontFamily = FontFamily(Font(R.font.imbplexsans_medium)),
                textAlign = TextAlign.Center
            )
        )
    }



    }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AjustesBox(navController: NavController){
    
    var text by remember { mutableStateOf("5.0") }


    Column(
        modifier = Modifier
            .size(width = 150.dp, height = 85.dp)
            .background(colorResource(id = R.color.menta_importante))
            .clip(RoundedCornerShape(12.dp))
            .padding(10.dp)
            .clickable { navController.navigate(route = DriverScreens.Ajustes.route) },
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(modifier =  Modifier.align(Alignment.Start)){
            Text("Ajustes",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_bold)),
                color = colorResource(id = R.color.fondo)
            )
        }
        Icon(painter = painterResource(id = R.drawable.ajustes),
            contentDescription = "Ajustes",
            modifier = Modifier
                .size(35.dp))

    }

}

@Composable
fun ModoPasajeroBox(){

    var text by remember { mutableStateOf("5.0") }

    Column(
        modifier = Modifier
            .size(width = 150.dp, height = 85.dp)
            .background(colorResource(id = R.color.menta_importante))
            .clip(RoundedCornerShape(12.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(modifier =  Modifier.align(Alignment.Start)){
            Text("Modo Pasajero",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_bold)),
                color = colorResource(id = R.color.fondo)
            )
        }
        Icon(painter = painterResource(id = R.drawable.carro),
            contentDescription = "Modo Pasajero",
            modifier = Modifier
                .size(35.dp))
    }

}





