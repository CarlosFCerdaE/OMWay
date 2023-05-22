package com.main.omwayapp.ui.screens.driver.Ajustes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.screens.driver.registerdriver.CenteredImage

@Composable
@Preview(showSystemUi=true)
fun Ajustes(){

    Column(modifier =
    Modifier
        .background(color = colorResource(id = R.color.fondo))
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(8.dp))

        CenteredImage(
            image = painterResource(id = R.drawable.logo_omway),
            size = DpSize(width = 504.dp, height = 100.dp)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        CustomDivider( modifier = Modifier.height(21.dp),)

        Text(
            text = "Ajustes",
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 30.dp, horizontal = 16.dp)
        )


        Spacer(modifier = Modifier.padding(10.dp))
        AjustesNombreUser()
        AjustesEmailUser()
        AjustesPhoneUser()
        Spacer(modifier = Modifier.padding(15.dp))


            GuardarCambios()
            Spacer(modifier = Modifier.padding(5.dp))
            CerrarSesion()



    }
        
}




@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AjustesNombreUser(){
    var text = remember {
        mutableStateOf("")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.Start
    ){
        InputField(
            modifier = Modifier
                .size(width=340.dp,height=70.dp),
            valueState = text,
            labelId = "Nombre",
            icon = painterResource(id = R.drawable.usuario),
            enabled = true,
            isSingleLine = true,
            keyboardType = KeyboardType.Text,
            onAction = KeyboardActions{
                keyBoardController?.hide()
            }
        )
    }

}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AjustesEmailUser(){
    var text = remember {
        mutableStateOf("")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.Start
    ){
        InputField(
            modifier = Modifier
                .size(width=340.dp,height=70.dp),
            valueState = text,
            labelId = "Email",
            icon = painterResource(id = R.drawable.email),
            enabled = true,
            isSingleLine = true,
            keyboardType = KeyboardType.Text,
            onAction = KeyboardActions{
                keyBoardController?.hide()
            }
        )
    }

}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AjustesPhoneUser(){
    var text = remember {
        mutableStateOf("")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.Start
    ){
        InputField(
            modifier = Modifier
                .size(width=340.dp,height=70.dp),
            valueState = text,
            labelId = "Telefono",
            icon = painterResource(id = R.drawable.telefono),
            enabled = true,
            isSingleLine = true,
            keyboardType = KeyboardType.Text,
            onAction = KeyboardActions{
                keyBoardController?.hide()
            }
        )
    }

}

@Composable
fun GuardarCambios(){

    Column(  horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Guardar",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
            color = colorResource(id = R.color.menta_importante),
            modifier = Modifier.clickable {}
                .align(Alignment.Start)
                .padding(vertical = 30.dp, horizontal = 16.dp)
        )
    }

}

@Composable
fun CerrarSesion(){

    Column(  horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Cerrar Sesion",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
            color = colorResource(id = R.color.menta_importante),
            modifier = Modifier.clickable {}
                .align(Alignment.Start)
                .padding(vertical = 10.dp, horizontal = 16.dp)
        )
    }

}



