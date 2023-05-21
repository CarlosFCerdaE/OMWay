package com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.Home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomDivider


@Composable
fun HomeDriver(){

    Column(modifier =
    Modifier
        .background(color = colorResource(id = R.color.fondo))
        .wrapContentSize(align = Alignment.Center)
    )
    {

        CustomDivider( modifier = Modifier.height(21.dp),)
        Text(
                text = "Bienvenido Driver Name",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
                color = colorResource(id = R.color.texto_general),
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 16.dp)
            )

        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Tú Resumen:",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )
        Column() {

        }
        Row(){
            Card(modifier = Modifier
                .size(width = 148.dp, height = 81.dp)
                .padding(horizontal = 12.dp),
                backgroundColor = colorResource(id = R.color.menta_importante),
                contentColor = colorResource(id = R.color.fondo),
                shape = RoundedCornerShape(12.dp)
            )

            {
                Column(){

                    Text(
                        text = "Viajes",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
                        color = colorResource(id = R.color.fondo),
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 5.dp)
                            .align(Alignment.Start)
                    )
                    Text(
                        text = "numero de viajes",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
                        color = colorResource(id = R.color.fondo),
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .align(Alignment.CenterHorizontally)

                    )
                }

            }
            Spacer(modifier = Modifier.padding(15.dp))

            Card(modifier = Modifier
                .size(width = 148.dp, height = 81.dp)
                .padding(horizontal = 12.dp),
                backgroundColor = colorResource(id = R.color.menta_importante),
                contentColor = colorResource(id = R.color.fondo),
                shape = RoundedCornerShape(12.dp)
            )

            {
                Column(){

                    Text(
                        text = "Total C$",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
                        color = colorResource(id = R.color.fondo),
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 5.dp)
                            .align(Alignment.Start)
                    )
                    Text(
                        text = "total",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.ibmplexsans_semibold)),
                        color = colorResource(id = R.color.fondo),
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .align(Alignment.CenterHorizontally)

                    )
                }

            }
        }



    }

}
@Composable
fun ViajesResume(){

    Card(modifier = Modifier
        .size(width = 148.dp, height = 81.dp)
        .padding(horizontal = 12.dp),
        backgroundColor = colorResource(id = R.color.menta_importante),
        contentColor = colorResource(id = R.color.fondo),
        shape = RoundedCornerShape(12.dp)
    ) {

    }
}
