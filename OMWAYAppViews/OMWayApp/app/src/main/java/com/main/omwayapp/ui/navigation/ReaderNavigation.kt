package com.main.omwayapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.main.omwayapp.apirest.model.LoginModel
import com.main.omwayapp.ui.screens.login.RLoginScreen
import com.main.omwayapp.ui.screens.splash.RSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.fragment.app.viewModels

@Composable
fun ReaderNavigation (loginModel: LoginModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name ){
        composable(ReaderScreens.SplashScreen.name){
            RSplashScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name){
            RLoginScreen(navController = navController ,loginModel = loginModel)
        }

    }
}