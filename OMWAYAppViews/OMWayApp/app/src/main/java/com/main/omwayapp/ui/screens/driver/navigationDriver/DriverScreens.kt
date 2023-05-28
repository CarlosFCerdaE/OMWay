package com.main.omwayapp.ui.screens.driver.navigationDriver


sealed class DriverScreens(val route: String){

    object RegisterDriver: DriverScreens("RegisterDriver")
    object TAC: DriverScreens("TermsAndConditions")
    object MenuTabDriver: DriverScreens("MenuTabDriver")
    object Ajustes: DriverScreens("Ajustes")
    object EditarCarro: DriverScreens("editarCarros")
    object AgregarCarro: DriverScreens("agregarCarros")

}
