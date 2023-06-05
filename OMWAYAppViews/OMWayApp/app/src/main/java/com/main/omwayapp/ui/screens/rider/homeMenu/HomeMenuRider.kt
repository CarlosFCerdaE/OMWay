package com.main.omwayapp.ui.screens.rider.homeMenu

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Build
import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.LatLng
import com.main.omwayapp.R
import com.main.omwayapp.apirest.model.omwayuser.RiderItem
import com.main.omwayapp.apirest.viewmodel.omwayuser.rider.RiderViewModel
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.model.Location
import com.main.omwayapp.ui.navigationApp.AppScreens

import com.main.omwayapp.ui.views.map.OurGoogleMaps
import kotlinx.coroutines.launch
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter",
    "StateFlowValueCalledInComposition"
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homemenuRider(navController: NavHostController) {

    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()
    val riderViewModel:RiderViewModel = viewModel()

    androidx.compose.material.Scaffold(backgroundColor = colorResource(id = R.color.fondo),scaffoldState=scaffoldState,topBar = {
        AppBarMapView (onNavigationIconClick = { scope.launch { scaffoldState.drawerState.open() } })

    },drawerGesturesEnabled = scaffoldState.drawerState.isOpen,drawerContent = {
        Log.d("VALUESINHOME","${riderViewModel.riderState.value.riderItem.name}")
        DrawerHeader()
        DrawerBody(items = listOf(
            MenuItem(id = "misviajes", title = "Mis Viajes", contentDescrip = "Go to", R.drawable.misviajes),
            MenuItem(id = "ajustes", title = "Ajustes", contentDescrip = "Go to",R.drawable.ajustes),
            MenuItem(id = "driver", title = "Driver", contentDescrip = "Go to",R.drawable.carro),
        ), onItemClick = {
            when(it.id){
                "misviajes"->navController.navigate(route= AppScreens.TAC.route)
                "ajustes"->navController.navigate(route= AppScreens.Ajustes.route)
                //"driver"->navController.navigate(route= AppScreens.ViajeDriver.route)
            }


        }, )
    }) {
        Mapa(navController)
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarMapView(onNavigationIconClick:()->Unit){

    TopAppBar(backgroundColor = colorResource(id = R.color.fondo), contentColor = Color.White,
        title = {
            Text(text = "")
        },
        navigationIcon = {
            androidx.compose.material.IconButton(onClick = onNavigationIconClick ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Toogle Drawer")

            }
        }
    )


}

@Composable
fun DrawerHeader(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(colorResource(id = R.color.menta_importante))){
        Column(modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally ) {
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {
                // Image(painter = , contentDescription = )
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.usuario_perfil),
                    contentDescription = "Tiempo",
                    modifier = Modifier
                        .padding(12.dp)
                        .width(60.dp)
                        .height(60.dp))
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Profile", fontSize = 20.sp,color=Color.Black, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold )
            }
        }

    }
}

@Composable
fun DrawerBody(items:List<MenuItem>, modifier: Modifier= Modifier
    .background(color = Color.Black)
    .fillMaxSize(), itemTextStyle:TextStyle= TextStyle(fontSize = 16.sp), onItemClick:(MenuItem)->Unit){
    LazyColumn(modifier){
        items(items){item->
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp)
            ){
                Image(painter=painterResource(id = item.icon), contentDescription = item.contentDescrip,modifier= Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .padding(5.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title, color = Color.White, fontSize = 20.sp)
            }

        }

    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Mapa(navController: NavHostController) {
    val uam = Location(LatLng(12.10877952, -86.2564972), "UAM", "Universidad Americana")
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    var notes:String by remember { mutableStateOf("Notas") }
    var location:String by remember { mutableStateOf("¿A donde vas?'") }

    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]


// Value for storing time as a string
    var mTime:String by remember { mutableStateOf("Tiempo") }

// Creating a TimePicker dialog
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        { _, mHour: Int, mMinute: Int ->
            val amPm: String = if (mHour < 12) "AM" else "PM"
            val hour12: Int = if (mHour == 0) 12 else if (mHour > 12) mHour - 12 else mHour
            val minuteFormatted: String = String.format("%02d", mMinute)
            mTime/*.value*/ = "$hour12:$minuteFormatted $amPm"
        },
        mHour,
        mMinute,
        false // Enable 12-hour format
    )
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
            ) {
                val context = LocalContext.current
                //SI ESTA CERRADA
                if (sheetState.isCollapsed) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(30.dp))
                        // A donde vas
                        TextField(value = location,
                            onValueChange = { location = it },
                            singleLine = true,
                            readOnly = false,
                            modifier = Modifier
                                .size(width = 300.dp, height = 60.dp)
                                .clip(RoundedCornerShape(5.dp)),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorResource(id = R.color.txt_fields),
                                focusedLabelColor = colorResource(id = R.color.texto_general),
                                unfocusedLabelColor = colorResource(id = R.color.texto_general)
                            ),
                            label = {
                                Text(
                                    text = ""/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp, color = colorResource(
                                    id = R.color.texto_general
                                )
                            ),
                            leadingIcon = {
                                IconButton(onClick = {/*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.punto_a),
                                        contentDescription = "Marca del carro",

                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                }
                            })

                        Spacer(modifier = Modifier.height(20.dp))
                        //Tiempo

                        TextField(value = mTime,
                            onValueChange = { mTime = it },
                            singleLine = true,
                            readOnly = true,
                            modifier = Modifier
                                .size(width = 300.dp, height = 60.dp)
                                .clickable { mTimePickerDialog.show() }
                                .clip(RoundedCornerShape(5.dp)),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorResource(id = R.color.txt_fields),
                                focusedLabelColor = colorResource(id = R.color.texto_general),
                                unfocusedLabelColor = colorResource(id = R.color.texto_general)
                            ),
                            label = {
                                Text(
                                    text = ""/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp, color = colorResource(
                                    id = R.color.texto_general
                                )
                            ),
                            leadingIcon = {
                                IconButton(onClick = {/*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.reloj),
                                        contentDescription = "Marca del carro",

                                        modifier = Modifier
                                            .clickable { mTimePickerDialog.show() }
                                            .size(24.dp)
                                    )
                                }
                            })

                        Spacer(modifier = Modifier.height(20.dp))
                        //Notas

                        TextField(value = notes,
                            onValueChange = { notes = it },
                            singleLine = true,
                            readOnly = false,
                            modifier = Modifier
                                .size(width = 300.dp, height = 60.dp)
                                .clip(RoundedCornerShape(5.dp)),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorResource(id = R.color.txt_fields),
                                focusedLabelColor = colorResource(id = R.color.texto_general),
                                unfocusedLabelColor = colorResource(id = R.color.texto_general)
                            ),
                            label = {
                                Text(
                                    text = ""/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp, color = colorResource(
                                    id = R.color.texto_general
                                )
                            ),
                            leadingIcon = {
                                IconButton(onClick = {/*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.notas),
                                        contentDescription = "Marca del carro",

                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                }
                            })


                        Spacer(modifier = Modifier.height(20.dp))
                        //Boton
                        CustomButton(
                            text = "Pedir Ahora",
                            modifier = Modifier.width(200.dp),
                            fontSize = 20.sp,
                            onClick = {navController.navigate(route= AppScreens.ViajeRider.route)}

                        )


                    }
                    //SI SE ABRE
                } else {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))
                        //Precio
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "            Precio C$:",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(5.dp),
                                color = Color.White,
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        // A donde vas
                        TextField(value = location,
                            onValueChange = { location = it },
                            singleLine = true,
                            readOnly = false,
                            modifier = Modifier
                                .size(width = 300.dp, height = 60.dp)
                                .clip(RoundedCornerShape(5.dp)),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorResource(id = R.color.txt_fields),
                                focusedLabelColor = colorResource(id = R.color.texto_general),
                                unfocusedLabelColor = colorResource(id = R.color.texto_general)
                            ),
                            label = {
                                Text(
                                    text = ""/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp, color = colorResource(
                                    id = R.color.texto_general
                                )
                            ),
                            leadingIcon = {
                                IconButton(onClick = {/*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.punto_a),
                                        contentDescription = "Marca del carro",

                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                }
                            })


                        Spacer(modifier = Modifier.height(20.dp))
                        //Tiempo
                        TextField(value = mTime,
                            onValueChange = { mTime = it },
                            singleLine = true,
                            readOnly = true,
                            modifier = Modifier
                                .size(width = 300.dp, height = 60.dp)
                                .clickable { mTimePickerDialog.show() }
                                .clip(RoundedCornerShape(5.dp)),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorResource(id = R.color.txt_fields),
                                focusedLabelColor = colorResource(id = R.color.texto_general),
                                unfocusedLabelColor = colorResource(id = R.color.texto_general)
                            ),
                            label = {
                                Text(
                                    text = ""/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp, color = colorResource(
                                    id = R.color.texto_general
                                )
                            ),
                            leadingIcon = {
                                IconButton(onClick = {/*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.reloj),
                                        contentDescription = "Marca del carro",

                                        modifier = Modifier
                                            .clickable { mTimePickerDialog.show() }
                                            .size(24.dp)
                                    )
                                }
                            })

                        Spacer(modifier = Modifier.height(20.dp))
                        //Notas
                        TextField(value = notes,
                            onValueChange = { notes = it },
                            singleLine = true,
                            readOnly = false,
                            modifier = Modifier
                                .size(width = 300.dp, height = 60.dp)
                                .clip(RoundedCornerShape(5.dp)),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = colorResource(id = R.color.txt_fields),
                                focusedLabelColor = colorResource(id = R.color.texto_general),
                                unfocusedLabelColor = colorResource(id = R.color.texto_general)
                            ),
                            label = {
                                Text(
                                    text = ""/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
                                )
                            },
                            textStyle = TextStyle(
                                fontSize = 16.sp, color = colorResource(
                                    id = R.color.texto_general
                                )
                            ),
                            leadingIcon = {
                                IconButton(onClick = {/*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.notas),
                                        contentDescription = "Marca del carro",

                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                }
                            })

                        Spacer(modifier = Modifier.height(20.dp))
                        //Boton
                        CustomButton(
                            text = "Pedir Ahora",
                            modifier = Modifier.width(200.dp),
                            fontSize = 20.sp,
                            onClick = {navController.navigate(route= AppScreens.ViajeRider.route)}
                        )


                    }
                }

            }

        }, sheetBackgroundColor = colorResource(id = R.color.fondo), sheetPeekHeight = 110.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //TestMap()
            OurGoogleMaps(uam) {}
        }


    }
}