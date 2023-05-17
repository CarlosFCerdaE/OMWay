package com.main.omwayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.compose.MapType
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.theme.OMWayAppTheme
import com.main.omwayapp.ui.views.driver.DriverView
import com.main.omwayapp.ui.views.map.MapView
import com.main.omwayapp.ui.views.rider.ReaderApp
import com.main.omwayapp.ui.views.rider.RiderView

//Hola amigos, bienvenidos a la app del futuro $$$
data class Location(val coordinate: LatLng,
                    val title:String,
                    val description:String)

//Unique id
var PERMISSION_ID=25
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OMWayAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        val uam=Location(LatLng(12.10877952,-86.2564972),"UAM","Universidad Americana")
                        OurGoogleMaps(uam){}
                    }*/
                    //MyApp()
                    //DriverView()
                    //RiderView()
                    //MapView()
                    ReaderApp()
                }
            }
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Preview(showSystemUi = true)
    @Composable
    fun MyApp(){
        var name = remember {
            mutableStateOf("")
        }
        var keyBoardController = LocalSoftwareKeyboardController.current


        Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            CustomDivider()

            InputField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                valueState = name,
                labelId = "Name",
                icon = painterResource(id = R.drawable.id),
                enabled = true,
                isSingleLine = true,
                keyboardType = KeyboardType.Text,
                onAction = KeyboardActions{
                    keyBoardController?.hide()
                }
            )


            CustomButton(modifier = Modifier.width(100.dp), text = "Ok") {
                
            }
        }



    }



}

