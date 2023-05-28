package com.main.omwayapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.theme.OMWayAppTheme

import androidx.compose.ui.unit.sp
import com.main.omwayapp.ui.views.rider.ReaderApp



import com.main.omwayapp.ui.views.rider.RiderView
import androidx.compose.ui.unit.sp
import cardSolicitudDriver
import com.google.android.gms.maps.MapView
import com.main.omwayapp.apirest.model.LoginModel
import com.main.omwayapp.ui.screens.driver.Ajustes.Ajustes
import com.main.omwayapp.ui.screens.driver.menuTabDriver.MenuTabDriver
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.Home.HomeDriver
import com.main.omwayapp.ui.screens.driver.mycars.agregarCarros
import com.main.omwayapp.ui.screens.driver.mycars.editarCarros
import com.main.omwayapp.ui.screens.driver.mycars.listMisCarros
import com.main.omwayapp.ui.screens.driver.mytrips.cardMytrips
import com.main.omwayapp.ui.screens.driver.registerdriver.RegisterDriver
import com.main.omwayapp.ui.screens.driver.termsAndConditions.TermsAndConditions
import com.main.omwayapp.ui.views.map.MapView


//Hola amigos, bienvenidos a la app del futuro $$$


//Unique id
var PERMISSION_ID=25
class MainActivity : ComponentActivity() {
    private val loginModel : LoginModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            OMWayAppTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //MyApp()
                    //DriverView()
                    //RiderView()
                   // RegisterDriver()
                    //BttmSheet()
                    //MapView()
                  //MenuTabDriver()
                   // TermsAndConditions()
                   // Ajustes()
                    //ReaderApp(loginModel = loginModel)
                    //cardSolicitudDriver()
                    //listMisCarros()
                    //agregarCarros()
                    //editarCarros()
                    cardMytrips()


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


            CustomButton(modifier = Modifier.width(100.dp), text = "Ok", fontSize = 10.sp) {
                
            }
        }



    }



}

