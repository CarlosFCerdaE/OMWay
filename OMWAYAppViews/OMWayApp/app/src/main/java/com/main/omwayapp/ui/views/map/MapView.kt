package com.main.omwayapp.ui.views.map

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.main.omwayapp.Location
import com.main.omwayapp.ui.components.CustomButton
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MapView() {

    BottomSheetScaffold(
        sheetContent = {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                ) {
                    val context = LocalContext.current
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement=Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        //Precio
                        //Text(text = "Precio C$:", fontSize = 18.sp, modifier = Modifier.padding(5.dp))
                        //Spacer(modifier = Modifier.height(20.dp))
                        // A donde vas
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.LightGray)
                            .clickable {
                                Toast
                                    .makeText(context, "Introducir Ubicacion", Toast.LENGTH_SHORT)
                                    .show()
                            }){

                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement=Arrangement.Center,
                            horizontalAlignment = Alignment.Start) {
                            Text(text = "¿A dónde vas?", fontSize = 17.sp,modifier = Modifier.padding(11.dp))



                        }

                    }
                        Spacer(modifier = Modifier.height(20.dp))
                        //Tiempo
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.LightGray)
                            .clickable {
                                Toast
                                    .makeText(context, "Introducir Tiempo", Toast.LENGTH_SHORT)
                                    .show()
                            }){

                            Column(modifier = Modifier.fillMaxSize(),
                                verticalArrangement=Arrangement.Center,
                                horizontalAlignment = Alignment.Start) {
                                Text(text = "Tiempo", fontSize = 17.sp, modifier = Modifier.padding(11.dp))



                            }

                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        //Notas
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.LightGray)
                            .clickable {
                                Toast
                                    .makeText(context, "Introducir Notas", Toast.LENGTH_SHORT)
                                    .show()
                            }){

                            Column(modifier = Modifier.fillMaxSize(),
                                verticalArrangement=Arrangement.Center,
                                horizontalAlignment = Alignment.Start) {
                                Text(text = "Notas", fontSize = 17.sp, modifier = Modifier.padding(11.dp))



                            }

                        }/*
                        Spacer(modifier = Modifier.height(20.dp))
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.LightGray)){

                        }
                        */
                        Spacer(modifier = Modifier.height(15.dp))
                        Column(modifier = Modifier.fillMaxWidth(),
                            verticalArrangement=Arrangement.Center,
                            horizontalAlignment = Alignment.Start) {
                            Text(text = "            Precio C$:", fontSize = 18.sp, modifier = Modifier.padding(5.dp),color=Color.White,)
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        //Boton
                        CustomButton(text = "Pedir Ahora", modifier = Modifier.width(200.dp), fontSize = 20.sp) {
                            
                        }
                }
            }

        }, sheetContainerColor = Color.DarkGray, sheetPeekHeight = 110.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            TestMap()
        }


        /*

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            val uam=Location(LatLng(12.10877952,-86.2564972),"UAM","Universidad Americana")
            OurGoogleMaps(uam){}
        }

         */

    }
}










