package com.main.omwayapp.ui.screens.driver.menuTabDriver

import androidx.compose.runtime.Composable
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.Home.HomeDriver
import com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.Solicitudes.Solicitudes

typealias ScreenFun = @Composable () ->Unit
sealed class TabsItem(
    var title: String,
    var screen: ScreenFun

)
{
    object itemHome: TabsItem("Home",{ HomeDriver() })
    //object itemSolicitudes: TabsItem("Solicitudes",{ Solicitudes() })
}