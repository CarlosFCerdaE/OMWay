package com.main.omwayapp.ui.screens.driver.registerdriver

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CenteredImage
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.CustomDivider



//Pantalla de registro driver
@Composable
fun RegisterDriver(navController: NavController){

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


        CustomDivider( modifier = Modifier.height(21.dp),)
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Regístrate como conductor" , fontSize = 22.sp, fontFamily = FontFamily(Font(R.font.inter_bold)), color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 10.dp, horizontal = 16.dp)
        )
        Text(text = "Por favor llenar todos los campos." , fontSize = 14.sp, fontFamily = FontFamily(Font(R.font.ibmplexsans_regular)), color = colorResource(id = R.color.texto_opacidad),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Datos de tu Licencia" , fontSize = 15.sp, fontFamily = FontFamily(Font(R.font.inter_bold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 10.dp, horizontal = 16.dp)
        )

        DlExpiraationDatePicker()

        Text(text = "Agregá tú carro" , fontSize = 15.sp, fontFamily = FontFamily(Font(R.font.inter_bold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 10.dp, horizontal = 16.dp)
        )

        PlacaTextField()
        ColorTextField()
        MakeExposedDropdownMenuBox()
        ModelTextField()
        CarYearTextField()
        Spacer(modifier = Modifier.padding(25.dp))
        CustomButton(modifier = Modifier.size(width=222.dp,height=51.dp),text = "Regístrate", fontSize = 20.sp, onClick = {})
        Spacer(modifier = Modifier.padding(25.dp))



    }
}








