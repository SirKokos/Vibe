package ru.sfedu.vibe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import ru.sfedu.vibe.R
import ru.sfedu.vibe.model.Destination


@Composable
fun selectPage(navHostController: NavHostController){
    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        Label(stringResource(id = R.string.select_page))
        Spacer(modifier = Modifier.height(60.dp))

        OutlinedButton(
            onClick = {navHostController.navigate(Destination.Entry.route) }
        ) {
            Text(text = stringResource(id = R.string.entry_button_Description))
        }
        Text(text = "Или")
        OutlinedButton(
            onClick =  {navHostController.navigate(Destination.Registration.route)}
        ) {
            Text(text = stringResource(id = R.string.create_acc))
            }

        }
    }

//@Composable
//fun buttonEntry(onClick: () -> Unit){
//    OutlinedButton(
//        onClick = {onClick }
//    ) {
//        Text(text = stringResource(id = R.string.entry_button_Description))
//    }
//}
//
//@Composable
//fun buttonCreate(onClick: () -> Unit){
//    OutlinedButton(
//        onClick = { onClick }
//    ) {
//        Text(text = stringResource(id = R.string.create_acc))
//    }
//}

