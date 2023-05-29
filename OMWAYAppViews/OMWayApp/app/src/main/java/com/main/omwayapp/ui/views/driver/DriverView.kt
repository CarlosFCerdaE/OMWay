package com.main.omwayapp.ui.views.driver

import android.annotation.SuppressLint
import android.graphics.fonts.Font

import android.os.Build
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.LatLng
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.model.Location
import com.main.omwayapp.ui.views.map.OurGoogleMaps

@Composable
fun DriverView(){
    CustomButton(text = "Hello", fontSize = 10.sp) {

    }
}

lateinit var tbt:String
lateinit var bttn:String
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun OnRoute() {
    tbt="Usted esta en camino"
    bttn="Estoy Aqui"
    TopBarDriver()
}
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Started(){
    tbt="Esta en el punto inicial del viaje"
    bttn="Iniciar"
    TopBarDriver()
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Charge(){
    tbt="El viaje ha iniciado"
    bttn="Cobrar"
    TopBarDriver()
}


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDriver(){
    Scaffold(topBar = { TopAppBar(
        elevation = 2.dp, backgroundColor = colorResource(id = R.color.fondo)) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = tbt,color= colorResource(id = R.color.menta_importante), fontSize = 20.sp, fontWeight = FontWeight.Bold )

        }

    }}) {
        BottmSheetDriver()
    }
}
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottmSheetDriver(){
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
                    .height(170.dp)
                    .background(color = colorResource(id = R.color.fondo))
            ) {
                val context = LocalContext.current

                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top

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

                        TxtFieldDname()

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
fun TxtFieldDname(){
    var DriverName: String by rememberSaveable{ mutableStateOf("") }
    var PointA: String by rememberSaveable{ mutableStateOf("") }
    var PointB: String by rememberSaveable{ mutableStateOf("") }
    DriverName="Pedro Pascal"
    PointA="Villa Fontana Norte"
    PointB="Universidad Americana (UAM) "
    Column() {


        Row() {
            Text(
                text = DriverName, fontSize = 18.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(10.dp)
            )
        }
        Row() {
            Image(
                painter = painterResource(id = R.drawable.punto_a),
                contentDescription = "Point A",
                modifier = Modifier
                    .padding(7.dp)
                    .width(10.dp)
                    .height(10.dp)
            )
            Text(
                text = PointA, fontSize = 10.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(5.dp)
            )
        }
        Row() {
            Image(
                painter = painterResource(id = R.drawable.punto_b),
                contentDescription = "Point B",
                modifier = Modifier
                    .padding(7.dp)
                    .width(10.dp)
                    .height(10.dp)
            )
            Text(
                text = PointB, fontSize = 10.sp,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier.padding(5.dp)
            )
        }
        Text(
            text = "Tiempo estimado de llegada: 8mins", fontSize = 10.sp,
            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
            color = colorResource(id = R.color.menta_importante),
            modifier = Modifier.padding(5.dp)
        )
    }
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CustomButton(text = bttn, modifier = Modifier
            .width(100.dp)
            .height(35.dp)
            .padding(5.dp), fontSize = 10.sp) {

        }
    }

    /*
            androidx.compose.material3.TextField(value = DriverName,
                onValueChange = { DriverName = it },
                singleLine = true,
                readOnly = true,
                modifier = Modifier
                    .size(width = 200.dp, height = 60.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .padding(5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.fondo),
                    focusedLabelColor = colorResource(id = R.color.texto_general),
                    unfocusedLabelColor = colorResource(id = R.color.texto_general)
                ),
                label = {
                    Text(
                        text = DriverName,/*,
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        color = colorResource(id = R.color.texto_general)*/
                    )
                },
                textStyle = TextStyle(
                    fontSize = 13.sp, color = colorResource(
                        id = R.color.texto_general
                    )
                )



            )

     */


}