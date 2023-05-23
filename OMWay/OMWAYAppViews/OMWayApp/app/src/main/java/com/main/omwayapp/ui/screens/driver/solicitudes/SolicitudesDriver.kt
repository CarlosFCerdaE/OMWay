import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.ExpandableCardDriver


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Preview(showSystemUi = true)
@Composable
fun cardSolicitudDriver(){
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.fondo))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Active",
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 5.dp, horizontal = 165.dp)
        )

        val checkedState = remember {
            mutableStateOf(true)
        }
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = SwitchDefaults.colors(Color.Green)
        )

        CustomDivider( modifier = Modifier.height(21.dp),)
        Spacer(modifier = Modifier.height(15.dp))
        ExpandableCardDriver(nomRider = "Hermenegildo Pancracio",
            tarifa = "Tarifa Estimada: 60C$",
            hora = "3:00 pm",
            puntoA = "Villa Fontana",
            puntoB = "Universida Americana UAM",
            distanciaEst = "Distancia Estimada: 2 Km")
        Spacer(modifier = Modifier.height(10.dp))
        ExpandableCardDriver(nomRider = "Carlos Cerda",
            tarifa = "Tarifa Estimada: 80 C$",
            hora = "6:00 pm",
            puntoA = "La Cascada",
            puntoB = "Universidad Americana UAM",
            distanciaEst = "Distancia Estimada: 8 Km")

    }

}


