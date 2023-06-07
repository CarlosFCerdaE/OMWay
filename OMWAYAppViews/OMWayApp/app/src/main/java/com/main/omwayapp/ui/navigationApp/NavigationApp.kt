package com.main.omwayapp.ui.navigationApp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.omwayapp.ui.screens.driver.Ajustes.Ajustes
import com.main.omwayapp.ui.screens.driver.menuTabDriver.MenuTabDriver
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars.agregarCarros
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars.editarCarros
import com.main.omwayapp.ui.screens.driver.registerdriver.RegisterDriver
import com.main.omwayapp.ui.screens.driver.termsAndConditions.TermsAndConditions
import com.main.omwayapp.ui.screens.driver.viajeDriver.viajeDriver
import com.main.omwayapp.ui.screens.login.RLoginScreen
import com.main.omwayapp.ui.screens.rider.homeMenu.homemenuRider
import com.main.omwayapp.ui.screens.rider.misViajesRider.MisViajesRider
import com.main.omwayapp.ui.screens.rider.register.RegisterRider
import com.main.omwayapp.ui.screens.rider.viajeRider.viajeRider
import com.main.omwayapp.ui.screens.splash.RSplashScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationApp(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.HomeMenuRider.route ){
        composable(route= AppScreens.SplashScreen.route){
            RSplashScreen(navController)
        }
        composable(route= AppScreens.Login.route){
            RLoginScreen(navController)
        }
        composable(route= AppScreens.RegisterRider.route){
            RegisterRider(navController)
        }

        composable(route= AppScreens.RegisterDriver.route){
            RegisterDriver(navController)
        }
        composable(route= AppScreens.MenuTabDriver.route){
            MenuTabDriver(navController)
        }
        composable(route= AppScreens.TAC.route){
            TermsAndConditions(navController)
        }
        composable(route= AppScreens.Ajustes.route){
            Ajustes(navController)
        }
        composable(route = AppScreens.EditarCarro.route){
            editarCarros(navController)
        }
        composable(route = AppScreens.AgregarCarro.route){
            agregarCarros(navController)
        }

        composable(route= AppScreens.HomeMenuRider.route){
            homemenuRider(navController)
        }
        composable(route= AppScreens.ViajeDriver.route){
            viajeDriver(navController)
        }
        composable(route= AppScreens.MisViajesRider.route){
            MisViajesRider(navController)
        }



    }
}