package ru.sfedu.vibe.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Divider

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black

import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sfedu.vibe.Const
import ru.sfedu.vibe.R


@Preview (showBackground = true)
@Composable
fun OtherProfile() {
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
        cardPhoto(R.drawable.someone_else)
        Divider(color = Color.Blue, thickness = 1.dp)
        boxAboutPerson("Низовцев","Онлайн",true)
        Divider(color = Color.Black, thickness = 1.5.dp)
        boxAboutPersonSpecially("Ростов-на-Дону","20.04.1997","https://metanit.com/kotlin/jetpack/6.1.php")
    }
}

@Composable
fun headerProfile(){
    Column() {
        Row(modifier = Modifier
            .width(Const.ROW_WIDTH_LOGO)
            .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(text = stringResource(id = R.string.app_name),
                fontSize = Const.FONT_SIZE_LOGO,
                fontFamily = FontFamily.Default,
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.logoheartpink),
                contentDescription = stringResource(id = R.string.app_name),
            )
        }
    }
}

@Composable
fun boxAboutPerson(Name: String,status: String,msg:Boolean){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Row(modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .fillMaxWidth()) {
            Text(text = Name, fontSize = 25.sp)
            Text(text = status, fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 5.dp),
                fontStyle = FontStyle.Italic
            )
            if(msg){
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.padding(horizontal = 1.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(2.dp, color = Black)
            ) {
                    Image(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = null,
                        modifier = Modifier.height(30.dp))
                }
            }
        }   //Онлайн оффлайн
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 60.dp, end = 1.dp, bottom = 15.dp)
            .heightIn(max = 100.dp)) {
            Text(text = "Тут типо о себе dsfsdf fdgdfgdf fdfgdfg", fontSize = 15.sp)
        }
    }
}

@Composable
fun boxAboutPersonSpecially(aboutCity: String,dataBirthday:String,linkSocial: String){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceAround,

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp),
                text = stringResource(id = R.string.city),
                fontSize = 20.sp,)
            Text(
                text = aboutCity,
                fontSize = 18.sp,

            )
        }
        Row(
            modifier = Modifier
            .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp),
                text = stringResource(id = R.string.birthday),
                fontSize = 20.sp)
            Text(
                modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp),
                text = dataBirthday,
                fontSize = 18.sp,
              )
        }
        Row(modifier = Modifier
            .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp),
                text = stringResource(id = R.string.link),
                fontSize = 20.sp)
            Text(
                text = linkSocial,
                fontSize = 18.sp)
        }
    }
}

@Composable
fun cardPhoto(IdPhoto: Int){
    Image(
        modifier = Modifier
            .background(Color.Black)
            .alpha(0.9f)
            .fillMaxWidth()
            .height(300.dp)
            .padding(10.dp)
            .clip(CircleShape)
            .heightIn(150.dp),
        painter = painterResource(id = IdPhoto),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

