package com.main.omwayapp.ui.navigation

import com.main.omwayapp.ui.screens.rider.register.RegisterRider

//Aqui se van agregando tadas las pantallas que se van a usar para navegar
enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    RegisterRiderScreen,
    HomeScreen,
    RegisterDriver,
    MenuTabDriver,
    Ajustes,
    EditarCarro,
    AgregarCarro,
    TermsAndConditions;


    companion object{
        fun fromRoute(route: String?):ReaderScreens
        =when(route?.substringBefore("/")){
          SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            RegisterRiderScreen.name -> RegisterRiderScreen
            RegisterDriver.name -> RegisterDriver
            TermsAndConditions.name -> TermsAndConditions
            MenuTabDriver.name -> MenuTabDriver
            EditarCarro.name -> EditarCarro
            AgregarCarro.name -> AgregarCarro
            Ajustes.name -> Ajustes
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }


}