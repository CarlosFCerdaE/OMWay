package com.main.omwayapp.ui.views.map


import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TextView

import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState

//import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
//import androidx.compose.material3.rememberBottomSheetScaffoldState
//import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

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

import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.main.omwayapp.R
//import com.main.omwayapp.Location
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.model.Location
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.util.Calendar

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context



@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MapView() {
    val mContext = LocalContext.current

    val uam=Location(LatLng(12.10877952,-86.2564972),"UAM","Universidad Americana")
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    // Declaring and initializing a calendar
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    // Value for storing time as a string
    val mTime = remember { mutableStateOf("") }

    // Creating a TimePicker dialog
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        {_, mHour : Int, mMinute: Int ->
            mTime.value = "$mHour:$mMinute"
        }, mHour, mMinute, false
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                ) {
                    val context = LocalContext.current
                    //SI ESTA CERRADA
                    if(sheetState.isCollapsed) {
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement=Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally) {

                            Spacer(modifier = Modifier.height(30.dp))
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
                                    mTimePickerDialog.show()
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

                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            //Boton
                            CustomButton(text = "Pedir Ahora", modifier = Modifier.width(200.dp), fontSize = 20.sp) {

                            }
                        }
                        //SI SE ABRE
                    }else{
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement=Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally) {

                            Spacer(modifier = Modifier.height(20.dp))
                            //Precio
                            Column(modifier = Modifier.fillMaxWidth(),
                                verticalArrangement=Arrangement.Center,
                                horizontalAlignment = Alignment.Start) {
                                Text(text = "            Precio C$:", fontSize = 18.sp, modifier = Modifier.padding(5.dp),color=Color.White,)
                            }
                            Spacer(modifier = Modifier.height(15.dp))
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
                                    mTimePickerDialog.show()
                                }){

                                Column(modifier = Modifier.fillMaxSize(),
                                    verticalArrangement=Arrangement.Center,
                                    horizontalAlignment = Alignment.Start) {
                                    if(mTime.equals("")){
                                        Text(text = "Tiempo", fontSize = 17.sp, modifier = Modifier.padding(11.dp))
                                    }
                                    else{
                                        Text(text = "${mTime.value}", fontSize = 17.sp, modifier = Modifier.padding(11.dp))
                                    }




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

                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            //Boton
                            CustomButton(text = "Pedir Ahora", modifier = Modifier.width(200.dp), fontSize = 20.sp) {

                            }
                        }
                    }

            }

        }, sheetBackgroundColor = Color.DarkGray, sheetPeekHeight = 95.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //TestMap()
            OurGoogleMaps(uam){}
        }


        /*

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            val uam=Location(LatLng(12.10877952,-86.2564972),"UAM","Universidad Americana")
            OurGoogleMaps(uam){}
        }

         */

    }
}












