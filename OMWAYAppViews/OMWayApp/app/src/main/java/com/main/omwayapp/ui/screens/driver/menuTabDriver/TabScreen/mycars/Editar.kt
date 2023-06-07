package com.main.omwayapp.ui.screens.driver.menuTabDriver.TabScreen.mycars
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.InputField

//@Preview(showSystemUi = true)
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun editarCarros(navController: NavController){

    var keyBoardController = LocalSoftwareKeyboardController.current

    var licensePlate = remember { mutableStateOf("") } //numero de placa carro
    var color = remember { mutableStateOf("") } //color de carro

    //MakeExposedDropdownMenuBox
    val context = LocalContext.current
    var MakeList = listOf("Toyota", "Nissan", "Kia")
    var expanded by remember { mutableStateOf(false) }
    var selectedMake by remember { mutableStateOf("") }

    var model = remember { mutableStateOf("") } // modelo del carro

    var yearCar = remember { mutableStateOf("") }  // año del carro
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
            text = "Editá tu carro",
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            color = colorResource(id = R.color.texto_general),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 30.dp, horizontal = 25.dp)
        )

        //Textfield numero de placa
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            InputField(
                modifier = Modifier
                    .size(width=330.dp,height=70.dp),
                valueState = licensePlate,
                labelId = "No.de Placa",
                icon = painterResource(id = R.drawable.placa),
                enabled = true,
                isSingleLine = true,
                keyboardType = KeyboardType.Text,
                onAction = KeyboardActions{
                    keyBoardController?.hide()
                }
            )
        }

        // MakeExposedDropdownMenuBox
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                TextField(
                    value = selectedMake,
                    onValueChange = {selectedMake = it},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .size(width = 330.dp, height = 70.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    colors = TextFieldDefaults.textFieldColors
                        (containerColor = colorResource(id = R.color.txt_fields)
                    ),
                    textStyle= TextStyle(fontSize=16.sp,color= colorResource(
                        id = R.color.texto_general)
                    ),
                    label = {
                        Text(text = "Marca",
                            color = colorResource(id = R.color.texto_general)
                        )
                    },
                    leadingIcon = {
                        IconButton(onClick = {/*TODO*/}){
                            Icon(painter = painterResource(id = R.drawable.carro),
                                contentDescription = "Marca del carro",
                                modifier = Modifier
                                    .size(24.dp))
                        }
                    }
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    MakeList.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedMake = item
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        //Text field modelo del carro
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            InputField(
                modifier = Modifier
                    .size(width=330.dp,height=70.dp),
                valueState = model,
                labelId = "Modelo",
                icon = painterResource(id = R.drawable.carro),
                enabled = true,
                isSingleLine = true,
                keyboardType = KeyboardType.Text,
                onAction = KeyboardActions{
                    keyBoardController?.hide()
                }
            )
        }

        //Texfield color de carro
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            InputField(
                modifier = Modifier
                    .size(width=330.dp,height=70.dp),
                valueState = color,
                labelId = "Color",
                icon = painterResource(id = R.drawable.color),
                enabled = true,
                isSingleLine = true,
                keyboardType = KeyboardType.Text,
                onAction = KeyboardActions{
                    keyBoardController?.hide()
                }
            )
        }
        // Text field año modelo
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            InputField(
                modifier = Modifier
                    .size(width=330.dp,height=70.dp),
                valueState = yearCar,
                labelId = "Año modelo",
                icon = painterResource(id = R.drawable.carro),
                enabled = true,
                isSingleLine = true,
                keyboardType = KeyboardType.Number,
                onAction = KeyboardActions{
                    keyBoardController?.hide()
                }
            )
        }

        Spacer(modifier = Modifier.padding(25.dp))
        CustomButton(modifier = Modifier
            .align(CenterHorizontally)
            .size(width=222.dp,height=51.dp),
            text = "Guardar",
            fontSize = 20.sp) {

        }
        Spacer(modifier = Modifier.padding(25.dp))


    }

}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PlacaTextFieldEditar(){
    var text = remember {
        mutableStateOf("M450950")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        InputField(
            modifier = Modifier
                .size(width=330.dp,height=70.dp),
            valueState = text,
            labelId = "No.de Placa",
            icon = painterResource(id = R.drawable.placa),
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
fun ColorTextFieldEditar(){
    var text = remember {
        mutableStateOf("Silver")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        InputField(
            modifier = Modifier
                .size(width=330.dp,height=70.dp),
            valueState = text,
            labelId = "Color",
            icon = painterResource(id = R.drawable.color),
            enabled = true,
            isSingleLine = true,
            keyboardType = KeyboardType.Text,
            onAction = KeyboardActions{
                keyBoardController?.hide()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakeEditar() {
    val context = LocalContext.current
    var MakeList = listOf("Toyota", "Nissan", "Kia")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Toyota") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {selectedText = it},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .size(width = 330.dp, height = 70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                colors = TextFieldDefaults.textFieldColors
                    (containerColor = colorResource(id = R.color.txt_fields)
                ),
                textStyle= TextStyle(fontSize=16.sp,color=colorResource(
                    id = R.color.texto_general)),
                label = {
                    Text(text = "Marca",
                        /*
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),*/
                        color = colorResource(id = R.color.texto_general)
                    )
                },
                leadingIcon = {
                    IconButton(onClick = {/*TODO*/}){
                        Icon(painter = painterResource(id = R.drawable.carro),
                            contentDescription = "Marca del carro",

                            modifier = Modifier
                                .size(24.dp))
                    }
                }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                MakeList.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ModelEditar() {

    var text = remember {
        mutableStateOf("")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            InputField(
                modifier = Modifier
                    .size(width=330.dp,height=70.dp),
                valueState = text,
                labelId = "Modelo",
                icon = painterResource(id = R.drawable.carro),
                enabled = true,
                isSingleLine = true,
                keyboardType = KeyboardType.Text,
                onAction = KeyboardActions{
                    keyBoardController?.hide()
                }
            )
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CarYearTextFieldEditar(){
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier
                .size(width = 330.dp, height = 70.dp),
            value = text,
            onValueChange = { newText -> text = newText },
            label = {
                Text(text = "Año del modelo",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.texto_general)
                )
            },
            textStyle=TextStyle(fontSize=16.sp,color=colorResource(
                id = R.color.texto_general)),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.carro),
                    contentDescription = "Icono de carro"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors
                (
                containerColor = colorResource(id = R.color.txt_fields)
            )
        )

    }

}

