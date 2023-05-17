package com.main.omwayapp.ui.navigation

//Aqui se van agregando tadas las pantallas que se van a usar para navegar
enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    RegisterRiderScreen,
    HomeScreen;

    companion object{
        fun fromRoute(route: String?):ReaderScreens
        =when(route?.substringBefore("/")){
          SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            RegisterRiderScreen.name -> RegisterRiderScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }


}