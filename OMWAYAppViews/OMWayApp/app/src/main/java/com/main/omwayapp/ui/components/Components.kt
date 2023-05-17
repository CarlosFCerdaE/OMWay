package com.main.omwayapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.omwayapp.ui.theme.Fondo
import com.main.omwayapp.ui.theme.MentaImportante40
import com.main.omwayapp.ui.theme.TextoGeneral
import com.main.omwayapp.ui.theme.TxtFields

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    icon: Painter,
    enabled: Boolean,
    isSingleLine: Boolean,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Go,
    onAction: KeyboardActions,
    colorFondo:Color = TxtFields,
    colorTexto:Color = TextoGeneral
){
    TextField(value = valueState.value , onValueChange = {valueState.value = it},
        modifier = modifier.padding(5.dp),
        label ={ Text(text = labelId)},
        leadingIcon = {Icon(painter = icon, contentDescription = "Text Field Icon")},
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        colors = TextFieldDefaults.textFieldColors(containerColor = colorFondo, textColor = colorTexto, focusedLabelColor = colorTexto, unfocusedLabelColor = colorTexto),
        shape = RoundedCornerShape(10.dp)
    )




}
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colorFondo:Color = MentaImportante40,
    text: String,
    textColor : Color = Fondo,
    onClick:()->Unit
){
    Button(onClick = onClick,
    modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = colorFondo),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        contentPadding = PaddingValues(4.dp)
        ) {
            Text(text = text,
                color = textColor
                )
    }

}

@Composable
fun CustomDivider(
    modifier: Modifier = Modifier,
    height:Dp = 30.dp,
    color: Color = MentaImportante40
){
    Box(
        modifier = modifier.fillMaxWidth().height(height).background(color)
    )
}