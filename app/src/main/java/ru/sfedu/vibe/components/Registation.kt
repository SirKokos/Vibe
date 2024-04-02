package ru.sfedu.vibe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import ru.sfedu.vibe.Const
import ru.sfedu.vibe.R
import ru.sfedu.vibe.model.Destination


@Composable
fun Label(header: String){
    Column() {
        Row(modifier = Modifier
            .width(Const.ROW_WIDTH_LOGO)
            .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(text = stringResource(id = R.string.app_name),
                fontSize = Const.FONT_SIZE_LOGO,
                fontFamily = FontFamily.Default)
            Image(
                painter = painterResource(id = R.drawable.logoheartpink),
                contentDescription = stringResource(id = R.string.app_name),
            )
        }
        Text(text = header,
            fontSize = Const.FONT_SIZE_CREATE_TEXT_ACC,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Light
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTextField(lableValue:String, paintRes:ImageVector ,typeField: KeyboardType){

    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        value = textValue.value,
        onValueChange = {textValue.value = it},
        label = {Text(text = lableValue)},

        leadingIcon = {
            Icon(imageVector = paintRes,
                contentDescription = "Dw")
        },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.blue_200),
            focusedLabelColor = colorResource(id = R.color.blue_200),
            cursorColor = colorResource(id = R.color.blue_200),
            containerColor = colorResource(id = R.color.field_container_sig_up),
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = typeField
        )

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myPasswordField(lableValue:String, paintRes: ImageVector, typeField: KeyboardType){
    val passwordValue = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        value = passwordValue.value,
        onValueChange = {passwordValue.value = it},
        label = { Text(text = lableValue) },

        leadingIcon = {
            Icon( imageVector = paintRes,
                contentDescription = stringResource(id = R.string.password_Description))
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Lock
            }else{
                Icons.Filled.Lock
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage , contentDescription = "")
            }
        },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.blue_200),
            focusedLabelColor = colorResource(id = R.color.blue_200),
            cursorColor = colorResource(id = R.color.blue_200),
            containerColor = colorResource(id = R.color.field_container_sig_up),
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = typeField
        )


    )
}

@Composable
fun ElevatedButtonExample(textButton: String,onClick: () -> Unit) {
    Spacer(modifier = Modifier.size(20.dp))
    ElevatedButton(onClick = { onClick() }) {
        Text(textButton)
    }
}


@Composable
fun registartion( navHostController: NavHostController){
    Column (modifier= Modifier.fillMaxSize()
        .background(Color.White)
        .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Label(stringResource(id = R.string.create_acc))
        Spacer(modifier = Modifier.height(60.dp))
        myTextField(lableValue =stringResource(id = R.string.email_Description) , Icons.Filled.Email, KeyboardType.Email)
        myTextField(lableValue = stringResource(id = R.string.full_name_Description), Icons.Filled.Person,KeyboardType.Text)
        myPasswordField(lableValue = stringResource(id = R.string.password_Description), Icons.Filled.Lock,KeyboardType.Password)
        ElevatedButtonExample(stringResource(id = R.string.registr_button_Description),onClick = {navHostController.navigate(Destination.ChatList.route)})
    }

}