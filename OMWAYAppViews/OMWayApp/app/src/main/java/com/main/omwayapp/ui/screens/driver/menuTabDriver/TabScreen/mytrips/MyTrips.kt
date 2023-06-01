package com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mytrips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.components.ExpandableCardTrips
import com.main.omwayapp.ui.components.ExpandableCardTripsDone


@OptIn(ExperimentalMaterialApi::class)
@Preview(showSystemUi = true)
@Composable
fun cardMytrips(){
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.fondo))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomDivider( modifier = Modifier.height(21.dp))
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Pendientes",
            color = colorResource(id = R.color.menta_importante),
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 40.dp)
        )
        ExpandableCardTrips(nomRider = "Hermenegildo Pancracio",
            tarifa = "Tarifa Estimada: 60C$",
            hora = "3:00 pm",
            puntoA = "Villa Fontana",
            puntoB = "Universida Americana UAM",
            distanciaEst = "Distancia Estimada: 2 Km")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Completados",
            color = colorResource(id = R.color.menta_importante),
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 40.dp)
        )
        ExpandableCardTripsDone(nomRider = "Vati Jurgen",
            tarifa = "Tarifa Pagada: 80 C$",
            hora = "01 de Mayo del 2023, 5:00 pm",
            puntoA = "Villa Fontana Norte",
            puntoB = "Universidad Americana UAM",
            distanciaRec = "Distancia: ",
            distancia = "1.5 Km",
            tiempo = "Tiempo: ",
            tiempotardado = "10 min."
        )

    }

}