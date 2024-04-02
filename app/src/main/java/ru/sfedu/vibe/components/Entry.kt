package ru.sfedu.vibe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.sfedu.vibe.R
import ru.sfedu.vibe.model.Destination


//@Preview(showBackground = true)
@Composable
fun entry(navHostController: NavHostController){
    Column (modifier= Modifier.fillMaxSize()
        .background(Color.White)
        .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Label(stringResource(id = R.string.entry_acc))
        Spacer(modifier = Modifier.height(60.dp))
        myTextField(lableValue = stringResource(id = R.string.email_Description) , Icons.Filled.Email, KeyboardType.Email)
        myPasswordField(lableValue = stringResource(id = R.string.password_Description), Icons.Filled.Lock,KeyboardType.Password)
        ElevatedButtonExample(stringResource(id = R.string.entry_button_Description),onClick = {navHostController.navigate(Destination.ChatList.route)})
    }

}