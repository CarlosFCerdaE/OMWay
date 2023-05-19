package com.main.omwayapp.ui.screens.driver.registerdriver

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.omwayapp.R
import com.main.omwayapp.ui.components.CustomButton
import com.main.omwayapp.ui.components.CustomDivider
import com.main.omwayapp.ui.components.InputField

import java.util.Calendar


@Preview(showSystemUi = true)
@Composable
fun RegisterDriver(){

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

        Column(modifier = Modifier.align(Alignment.Start)) {

            Text(text = "Agregá la foto de  tu licencia" , fontSize = 14.sp, fontFamily = FontFamily(Font(R.font.ibmplexsans_regular)), color = colorResource(id = R.color.texto_opacidad),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 15.dp, horizontal = 16.dp)
            )
            Row(modifier = Modifier
                .align(Alignment.Start)
                .padding(5.dp)){
                Box(contentAlignment = Alignment.BottomStart){
                    Image(
                        painter = painterResource(id = R.drawable.licencia),
                        contentDescription = "Licencia",
                        modifier = Modifier
                            .size(width = 109.dp, height = 91.dp),
                        alignment = Alignment.Center
                    )

                }
                Spacer(Modifier.padding(5.dp))

                CustomButton(modifier = Modifier
                    .size(width = 108.dp, height = 34.dp)
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 5.dp), text = "Agregar", fontSize = 14.sp){}
            }


        }
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
        ModelExposedDropdownMenuBox()
        CarYearTextField()
        Spacer(modifier = Modifier.padding(10.dp))
        CustomButton(modifier = Modifier.size(width=222.dp,height=51.dp),text = "Regístrate", fontSize = 20.sp) {
            
        }





    }
}

@Composable
fun CenteredImage(image: Painter, size: DpSize) {
    Box(
        contentAlignment = Alignment.TopCenter,
    ) {
        Image(
            painter = image,
            contentDescription = "OMWayLogo",
            modifier = Modifier
                .size(size.width,size.height),
            alignment = Alignment.Center
        )
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DlExpiraationDatePicker(){

    var date: String by rememberSaveable{ mutableStateOf("") }
    val yearDl: Int
    val monthDl: Int
    val dayDl: Int
    val mCalendar: Calendar = Calendar.getInstance()
    yearDl = mCalendar.get(Calendar.YEAR)
    monthDl = mCalendar.get(Calendar.MONTH)
    dayDl = mCalendar.get(Calendar.DAY_OF_MONTH)

    val mDatePickerDialog = DatePickerDialog(
        LocalContext.current,
        {
                _:DatePicker, yearDl:Int,monthDl:Int,dayDl:Int ->
            date = "$yearDl/${monthDl+1}/$dayDl"
        },yearDl,monthDl,dayDl
    )
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalAlignment = Alignment.Start)
    {

        TextField(value = date,
            onValueChange = {date=it},
            singleLine = true,
            readOnly = true,
            modifier = Modifier
                .size(width = 330.dp, height = 70.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(id = R.color.txt_fields),
                focusedTextColor =  colorResource(id =R.color.texto_general), focusedLabelColor = colorResource(id =R.color.texto_general), unfocusedLabelColor = colorResource(id =R.color.texto_general)
            ),
            label = {
                Text(text = "Fecha de vencimiento"/*,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = colorResource(id = R.color.texto_general)*/
                )
            },
            leadingIcon = {
                IconButton(onClick = {/*TODO*/}){
                    Icon(painter = painterResource(id = R.drawable.calendario),
                        contentDescription = "Calendario",

                        modifier = Modifier
                            .clickable { mDatePickerDialog.show() }
                            .size(24.dp))
                }
            }


        )
    }
}



@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PlacaTextField(){
    var text = remember {
        mutableStateOf("")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
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
fun ColorTextField(){
    var text = remember {
        mutableStateOf("")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
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
fun MakeExposedDropdownMenuBox() {
    val context = LocalContext.current
    var MakeList = listOf("Toyota", "Nissan", "Kia")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
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
                    (containerColor = colorResource(id = R.color.txt_fields),
                    focusedTextColor = colorResource(
                        id = R.color.texto_general)
                ),
                textStyle=TextStyle(fontSize=12.sp,color=colorResource(
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelExposedDropdownMenuBox() {
    val context = LocalContext.current
    var ModelList = listOf("Model1", "Model2", "Model3")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
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
                    (containerColor = colorResource(id = R.color.txt_fields),
                    focusedTextColor = colorResource(
                        id = R.color.texto_general)
                ),
                textStyle=TextStyle(fontSize=12.sp,color=colorResource(
                    id = R.color.texto_general)),
                label = {
                    Text(text = "Modelo",/*
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),*/
                        color = colorResource(id = R.color.texto_general)
                    )
                },
                leadingIcon = {
                    IconButton(onClick = {/*TODO*/}){
                        Icon(painter = painterResource(id = R.drawable.carro),
                            contentDescription = "Modelo del carro",

                            modifier = Modifier
                                .size(24.dp))
                    }
                }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                ModelList.forEach { item ->
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
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CarYearTextField(){
    var text = remember {
        mutableStateOf("")
    }
    var keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start
    ){
        InputField(
            modifier = Modifier
                .size(width=330.dp,height=70.dp),
            valueState = text,
            labelId = "Año del modelo",
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


