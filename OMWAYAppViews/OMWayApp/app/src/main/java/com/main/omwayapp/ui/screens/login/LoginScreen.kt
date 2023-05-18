package com.main.omwayapp.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.omwayapp.R
import com.main.omwayapp.apirest.model.LoginModel
import com.main.omwayapp.ui.components.CenteredImage
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.CustomButtonG
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.components.InputField
import com.main.omwayapp.ui.theme.Fondo
import com.main.omwayapp.ui.theme.IBMplexSans
import com.main.omwayapp.ui.theme.TextOpacidad
import com.main.omwayapp.ui.theme.TextoGeneral

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RLoginScreen (navController: NavController,loginModel: LoginModel){
    var cif = remember {
        mutableStateOf(loginModel.cif)
    }
    var password = remember {
        mutableStateOf(loginModel.password)
    }

    val context = LocalContext.current

    var keyBoardController = LocalSoftwareKeyboardController.current
    Surface(modifier = Modifier.fillMaxSize(), color = Fondo){
       
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {

            CenteredImage(image = painterResource(id = R.drawable.logo_omway),
                size = DpSize(width = 350.dp, height = 150.dp)
            )

            CustomDivider()

            Spacer(modifier = Modifier.height(50.dp))

                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(vertical = 10.dp, horizontal = 30.dp),
                    text = "Login",
                    color = TextoGeneral,
                    textAlign = TextAlign.Start,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = IBMplexSans


                )



            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 30.dp),
                text = "Por favor ingrese para continuar.",
                color = TextOpacidad,
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = IBMplexSans


            )

            Spacer(modifier = Modifier.height(5.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    valueState = loginModel.cif,
                    labelId = "Cif",
                    icon = painterResource(id = R.drawable.usuario),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )

                Spacer(modifier = Modifier.height(15.dp))

                InputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical= 4.dp),
                    valueState = loginModel.password,
                    labelId = "Contraseña",
                    icon = painterResource(id = R.drawable.password),
                    enabled = true,
                    isSingleLine = true,
                    keyboardType = KeyboardType.Text,
                    onAction = KeyboardActions{

                    }
                )
                Spacer(modifier = Modifier.height(25.dp))

                CustomButtonG(modifier = Modifier.width(222.dp).height(51.dp), text = "LOGIN", fontSize = 20.sp) {
                    val loginResponse = loginModel.onSummit()
                    Toast.makeText(context,loginResponse.msg,Toast.LENGTH_LONG).show()
                }





            }



        }
    }

}

