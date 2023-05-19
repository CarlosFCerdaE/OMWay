package com.main.omwayapp.ui.views.rider

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.main.omwayapp.apirest.model.LoginModel
import com.main.omwayapp.ui.components.CustomButton

import com.main.omwayapp.ui.navigation.ReaderNavigation



@Composable
fun RiderView(){

    CustomButton(text = "Hello", fontSize = 10.sp){}
    
}

@Composable
fun ReaderApp(loginModel: LoginModel){

    ReaderNavigation(loginModel = loginModel)

}