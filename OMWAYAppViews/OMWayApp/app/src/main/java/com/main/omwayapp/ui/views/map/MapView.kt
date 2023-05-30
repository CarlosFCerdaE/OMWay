package com.main.omwayapp.ui.views.map


import android.app.TimePickerDialog

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState

//import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.rememberBottomSheetScaffoldState
//import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
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

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.google.android.gms.maps.model.LatLng
import com.main.omwayapp.R
//import com.main.omwayapp.Location
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.model.Location
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.util.Calendar

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context



@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MapView() {
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
                        androidx.compose.material3.TextField(value = location,
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
                        /*
                        Box(modifier = Modifier
                            .height(55.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = colorResource(id = R.color.txt_fields))
                            .clickable {
                                Toast
                                    .makeText(
                                        context,
                                        "Introducir Ubicacion",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }) {

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row() {
                                    Image(
                                        painter = painterResource(id = R.drawable.punto_a),
                                        contentDescription = "Point A",
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .width(30.dp)
                                            .height(30.dp)
                                    )
                                    Text(
                                        text = "¿A dónde vas?",
                                        fontSize = 17.sp,
                                        modifier = Modifier.padding(11.dp),
                                        color = colorResource(
                                            id = R.color.texto_opacidad
                                        )
                                    )
                                }


                            }

                        }*/
                        Spacer(modifier = Modifier.height(20.dp))
                        //Tiempo

                        androidx.compose.material3.TextField(value = mTime,
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
                        /*
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = colorResource(id = R.color.txt_fields))
                            .clickable {
                                Toast
                                    .makeText(context, "Introducir Tiempo", Toast.LENGTH_SHORT)
                                    .show()
                            }) {

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row() {
                                    Image(
                                        painter = painterResource(id = R.drawable.reloj),
                                        contentDescription = "Point A",
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .width(30.dp)
                                            .height(30.dp)
                                    )
                                    Text(
                                        text = "Tiempo",
                                        fontSize = 17.sp,
                                        modifier = Modifier.padding(11.dp),
                                        color = colorResource(
                                            id = R.color.texto_opacidad
                                        )
                                    )

                                }

                            }

                        }*/
                        Spacer(modifier = Modifier.height(20.dp))
                        //Notas

                        androidx.compose.material3.TextField(value = notes,
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
                        /*
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = colorResource(id = R.color.txt_fields))
                            .clickable {
                                Toast
                                    .makeText(context, "Introducir Notas", Toast.LENGTH_SHORT)
                                    .show()
                            }) {

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row() {
                                    Image(
                                        painter = painterResource(id = R.drawable.notas),
                                        contentDescription = "Tiempo",
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .width(30.dp)
                                            .height(30.dp)
                                    )
                                    Text(
                                        text = "Notas",
                                        fontSize = 17.sp,
                                        modifier = Modifier.padding(11.dp),
                                        color = colorResource(
                                            id = R.color.texto_opacidad
                                        )
                                    )


                                }
                            }

                        }*/

                        Spacer(modifier = Modifier.height(20.dp))
                        //Boton
                        CustomButton(
                            text = "Pedir Ahora",
                            modifier = Modifier.width(200.dp),
                            fontSize = 20.sp
                        ) {

                        }
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
                        androidx.compose.material3.TextField(value = location,
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
                        /*
                       Box(modifier = Modifier
                           .height(50.dp)
                           .width(300.dp)
                           .padding(4.dp)
                           .clip(RoundedCornerShape(10.dp))
                           .background(color = colorResource(id = R.color.txt_fields))
                           .clickable {
                               Toast
                                   .makeText(
                                       context,
                                       "Introducir Ubicacion",
                                       Toast.LENGTH_SHORT
                                   )
                                   .show()
                           }) {

                           Column(
                               modifier = Modifier.fillMaxSize(),
                               verticalArrangement = Arrangement.Center,
                               horizontalAlignment = Alignment.Start
                           ) {
                               Row() {
                                   Image(
                                       painter = painterResource(id = R.drawable.punto_a),
                                       contentDescription = "Point A",
                                       modifier = Modifier
                                           .padding(12.dp)
                                           .width(30.dp)
                                           .height(30.dp)
                                   )
                                   Text(
                                       text = "¿A dónde vas?",
                                       fontSize = 17.sp,
                                       modifier = Modifier.padding(11.dp),
                                       color = colorResource(
                                           id = R.color.texto_opacidad
                                       )
                                   )
                               }


                           }

                       }*/
                        Spacer(modifier = Modifier.height(20.dp))
                        //Tiempo
                        androidx.compose.material3.TextField(value = mTime,
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
                        androidx.compose.material3.TextField(value = notes,
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
                        /*
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = colorResource(id = R.color.txt_fields))
                            .clickable {
                                Toast
                                    .makeText(context, "Introducir Notas", Toast.LENGTH_SHORT)
                                    .show()
                            }) {

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row() {
                                    Image(
                                        painter = painterResource(id = R.drawable.notas),
                                        contentDescription = "Tiempo",
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .width(30.dp)
                                            .height(30.dp)
                                    )
                                    Text(
                                        text = "Notas",
                                        fontSize = 17.sp,
                                        modifier = Modifier.padding(11.dp),
                                        color = colorResource(
                                            id = R.color.texto_opacidad
                                        )
                                    )


                                }
                            }

                        }

                         */

                        Spacer(modifier = Modifier.height(20.dp))
                        //Boton
                        CustomButton(
                            text = "Pedir Ahora",
                            modifier = Modifier.width(200.dp),
                            fontSize = 20.sp
                        ) {

                        }
                    }
                }

            }

        }, sheetBackgroundColor = colorResource(id = R.color.fondo), sheetPeekHeight = 110.dp
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            //TestMap()
            OurGoogleMaps(uam) {}
        }


        /*

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            val uam=Location(LatLng(12.10877952,-86.2564972),"UAM","Universidad Americana")
            OurGoogleMaps(uam){}
        }

         */

    }
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun timetxtfield(){

    androidx.compose.material3.TextField(value = timeBox,
        onValueChange = { timeBox = it },
        singleLine = true,
        readOnly = true,
        modifier = Modifier
            .size(width = 330.dp, height = 70.dp)
            .clip(RoundedCornerShape(10.dp)),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = colorResource(id = R.color.txt_fields),
            focusedLabelColor = colorResource(id = R.color.texto_general),
            unfocusedLabelColor = colorResource(id = R.color.texto_general)
        ),
        label = {
            Text(
                text = "Fecha de vencimiento"/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
            )
        },
        textStyle = TextStyle(
            fontSize = 13.sp, color = colorResource(
                id = R.color.texto_general
            )
        ))

        }

 */
















