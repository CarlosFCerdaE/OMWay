package com.main.omwayapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.omwayapp.ui.screens.driver.Ajustes.Ajustes
import com.main.omwayapp.ui.screens.driver.menuTabDriver.MenuTabDriver
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars.agregarCarros
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars.editarCarros
import com.main.omwayapp.ui.screens.driver.navigationDriver.DriverScreens
import com.main.omwayapp.ui.screens.driver.registerdriver.RegisterDriver
import com.main.omwayapp.ui.screens.driver.termsAndConditions.TermsAndConditions
import com.main.omwayapp.ui.screens.login.RLoginScreen
import com.main.omwayapp.ui.screens.splash.RSplashScreen
import java.io.Reader

@Composable
fun ReaderNavigation () {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name ){
        composable(ReaderScreens.SplashScreen.name){
            RSplashScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name){
            RLoginScreen(navController = navController)
        }

        //Pantallas Driver
        composable(route= ReaderScreens.RegisterDriver.name){
            RegisterDriver(navController)
        }
        composable(route= ReaderScreens.TermsAndConditions.name){
            TermsAndConditions(navController)
        }
        composable(route= ReaderScreens.MenuTabDriver.name){
            MenuTabDriver(navController)
        }

        composable(route= ReaderScreens.Ajustes.name){
            Ajustes(navController)
        }

        composable(route = ReaderScreens.EditarCarro.name){
            editarCarros(navController)
        }
        composable(route = ReaderScreens.AgregarCarro.name){
            agregarCarros(navController)
        }

    }
}