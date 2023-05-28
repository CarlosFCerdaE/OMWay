package com.main.omwayapp.ui.screens.driver.navigationDriver

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.omwayapp.ui.navigation.ReaderScreens
import com.main.omwayapp.ui.screens.driver.Ajustes.Ajustes
import com.main.omwayapp.ui.screens.driver.menuTabDriver.MenuTabDriver
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars.agregarCarros
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars.editarCarros
import com.main.omwayapp.ui.screens.driver.registerdriver.RegisterDriver
import com.main.omwayapp.ui.screens.driver.termsAndConditions.TermsAndConditions

@Composable
fun NavigationDriver(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DriverScreens.RegisterDriver.route ){
        composable(route=DriverScreens.RegisterDriver.route){
            RegisterDriver(navController)
        }
        composable(route= DriverScreens.MenuTabDriver.route){
            MenuTabDriver(navController)
        }
        composable(route=DriverScreens.TAC.route){
            TermsAndConditions(navController)
        }
        composable(route= DriverScreens.Ajustes.route){
            Ajustes(navController)
        }
        composable(route = DriverScreens.EditarCarro.route){
            editarCarros(navController)
        }
        composable(route = DriverScreens.AgregarCarro.route){
            agregarCarros(navController)
        }
    }
}