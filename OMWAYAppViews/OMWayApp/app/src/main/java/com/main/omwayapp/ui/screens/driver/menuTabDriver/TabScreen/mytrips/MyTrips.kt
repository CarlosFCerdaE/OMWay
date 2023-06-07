package com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mytrips

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.main.omwayapp.R
import com.main.omwayapp.apirest.viewmodel.omwayuser.driver.DriverViewModel
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.components.ExpandableCardTrips
import com.main.omwayapp.ui.components.ExpandableCardTripsDone
import com.main.omwayapp.ui.configDS.DataStoreManager
import kotlinx.coroutines.flow.first


@OptIn(ExperimentalMaterialApi::class)
@Preview(showSystemUi = true)
@Composable
fun cardMytrips() {

    val context = LocalContext.current
    //ViewModel
    ///Driver Get ViewModel
    val driverModel: DriverViewModel = viewModel()
    val driverState by driverModel._driverState.collectAsState()
    val isDriverLoading = remember { mutableStateOf(false) }

    //Values
    val cif = remember { mutableStateOf("") }
    //Storage

    val dataStore = DataStoreManager(context)

    //Get Cif From DataStorage
    LaunchedEffect(Unit) {
        val value = dataStore.getValue.first()
        if (value != null) {
            cif.value = value
            driverModel.findDriverByCif(cif.value)
        }
    }
    //Get Driver With Cif
    LaunchedEffect(driverState) {
        isDriverLoading.value = driverState._loading
        Log.d("STATE", isDriverLoading.value.toString())
    }

    if (!isDriverLoading.value) {
        val rides= remember { mutableStateOf(driverModel.driverState.value.driverItem.driverRides) }

        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.fondo))
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomDivider(modifier = Modifier.height(21.dp))
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Pendientes",
                color = colorResource(id = R.color.menta_importante),
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 40.dp)
            )
            ExpandableCardTrips(
                nomRider = "Hermenegildo Pancracio",
                tarifa = "Tarifa Estimada: 60C$",
                hora = "3:00 pm",
                puntoA = "Villa Fontana",
                puntoB = "Universida Americana UAM",
                distanciaEst = "Distancia Estimada: 2 Km"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Completados",
                color = colorResource(id = R.color.menta_importante),
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 40.dp)
            )
            for(ride in rides.value) {
                ExpandableCardTripsDone(
                    nomRider = ride.rider.name,
                    tarifa = ride.fare.toString(),
                    hora = ride.dropOffTime.toString(),
                    puntoA = ride.pickUpLocation,
                    puntoB = ride.dropOffLocation,
                    distanciaRec = "Distancia: ",
                    distancia = ride.distance.toString(),
                    tiempo = "Tiempo: ",
                    tiempotardado = "10 min."
                )
            }

        }

    }
}