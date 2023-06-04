package com.main.omwayapp.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.main.omwayapp.R

import com.main.omwayapp.ui.navigationApp.AppScreens
import com.main.omwayapp.ui.theme.Fondo
import kotlinx.coroutines.delay

//@Preview
@Composable
fun RSplashScreen(navController: NavController /*= NavController(context = LocalContext.current)*/) {


    LaunchedEffect(key1 = true) {
        delay(5000L)
        navController.navigate(AppScreens.SplashScreen.route)
    }
    Surface(color = Fondo) {


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_omway),
                "",
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)
            )
        }
    }
}