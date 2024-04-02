package ru.sfedu.vibe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sfedu.vibe.R

@Preview(showBackground = true)
@Composable
fun MyProfile() {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(50) }
    Column(modifier = Modifier
        .fillMaxSize()
    ) {

        Box(modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(70.dp))
        {
            headerProfile()
        }
        cardPhoto(R.drawable.ali)
        Divider(color = Color.Blue, thickness = 1.dp)
        boxAboutPerson("Margo","Онлайн",false)
        Divider(color = Color.Black, thickness = 1.5.dp)
        boxAboutPersonSpecially("Ростов-на-Дону","20.04.1997","http:\\efwe\\fwef")
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            onClick = { /*TODO*/ },
        ) {
            Text(text = stringResource(id = R.string.edit_batton))
        }
    }


}
