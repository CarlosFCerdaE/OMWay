package com.main.omwayapp.ui.views.rider

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.LatLng
import com.main.omwayapp.R
import com.main.omwayapp.apirest.model.LoginModel
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.model.Location

import com.main.omwayapp.ui.navigation.ReaderNavigation
import com.main.omwayapp.ui.views.map.OurGoogleMaps
import java.time.Year


@Composable
fun RiderView(){

    CustomButton(text = "Hello", fontSize = 10.sp){}

}


lateinit var tbtr:String

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(
    ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun DriverOnTheWay() {
    tbtr="El driver esta en camino"
    TopBarRider()
}
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Arrived(){
    tbtr="El conductor ha llegado"
    TopBarRider()
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun StartedRider(){
    tbtr="Viaje Iniciado"

    TopBarRider()
}


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarRider(){
    Scaffold(topBar = { TopAppBar(
        elevation = 2.dp, backgroundColor = colorResource(id = R.color.fondo)
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = tbtr,color= colorResource(id = R.color.menta_importante), fontSize = 20.sp, fontWeight = FontWeight.Bold )

        }

    }
    }) {
        BottmSheetRider()
    }

}
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottmSheetRider(){
    val uam= Location(LatLng(12.10877952,-86.2564972),"UAM","Universidad Americana")

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Expanded
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )


    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(color = colorResource(id = R.color.fondo))
            ) {
                val context = LocalContext.current

                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Image(
                        painter = painterResource(id = R.drawable.usuario_perfil),
                        contentDescription = "Driver",
                        modifier = Modifier
                            .padding(15.dp)
                            .width(80.dp)
                            .height(80.dp)
                    )
                    Column(
                        //modifier = Modifier.fillMaxSize(),
                        //verticalArrangement = Arrangement.Top,
                        //horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TxtFieldR()

                    }

                }




            }

        }, sheetBackgroundColor = colorResource(id = R.color.fondo), sheetPeekHeight = 30.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //TestMap()
            OurGoogleMaps(uam) {}
        }

    }
}
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TxtFieldR() {
    var marca: String by rememberSaveable { mutableStateOf("") }
    var modelo: String by rememberSaveable { mutableStateOf("") }
    var año: String by rememberSaveable { mutableStateOf("") }
    var color: String by rememberSaveable { mutableStateOf("") }
    var placa: String by rememberSaveable { mutableStateOf("") }
    marca="Toyota"
    modelo="Corolla"
    año="2015"
    color="Azul Oscuro"
    placa="M23453"
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


        Row() {
            Text(
                text = marca, fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = modelo, fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = año, fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(2.dp)
            )
        }
        Row() {
            Text(
                text = color, fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(2.dp)
            )

            Text(
                text = placa, fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(2.dp)
            )
        }
        Row() {
            Text(
                text = "Tiempo estimado de llegada: 8mins", fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.menta_importante),
                modifier = Modifier.padding(5.dp)
            )
        }

    }

}
@Composable
fun ReaderApp(loginModel: LoginModel) {

    ReaderNavigation(loginModel = loginModel)

}
