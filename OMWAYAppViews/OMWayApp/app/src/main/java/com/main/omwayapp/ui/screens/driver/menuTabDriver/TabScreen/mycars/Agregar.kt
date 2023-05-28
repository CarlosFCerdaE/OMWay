package com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.screens.driver.registerdriver.CarYearTextField
import com.main.omwayapp.ui.screens.driver.registerdriver.ColorTextField
import com.main.omwayapp.ui.screens.driver.registerdriver.MakeExposedDropdownMenuBox
import com.main.omwayapp.ui.screens.driver.registerdriver.ModelExposedDropdownMenuBox
import com.main.omwayapp.ui.screens.driver.registerdriver.PlacaTextField

//@Preview(showSystemUi = true)
@Composable
fun agregarCarros(navController: NavController){
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.fondo))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            painter = painterResource(id = R.drawable.regresar),
            contentDescription = "Carro",
            tint = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .size(35.dp)
        )
        Text(
            text = "Agregá tu carro",
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 30.dp, horizontal = 25.dp)
        )

        PlacaTextField()
        ColorTextField()
        MakeExposedDropdownMenuBox()
        ModelExposedDropdownMenuBox()
        CarYearTextField()
        Spacer(modifier = Modifier.padding(25.dp))
        CustomButton(modifier = Modifier
            .align(CenterHorizontally)
            .size(width=222.dp,height=51.dp),
            text = "Agregar",
            fontSize = 20.sp) {

        }
        Spacer(modifier = Modifier.padding(25.dp))


    }

}