package ru.sfedu.vibe.components

import androidx.compose.material3.DrawerValue
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.sfedu.vibe.Const
import ru.sfedu.vibe.R
import ru.sfedu.vibe.data.DataCardMsg
import ru.sfedu.vibe.data.DataNavigationItem
import ru.sfedu.vibe.data.DataSource


@Composable
fun MyChats(
    chatList:List<DataCardMsg>,
    modifier: Modifier = Modifier,
    corutin: CoroutineScope,
    navBarState : DrawerState
){
    LazyColumn( modifier = Modifier){
        item (){
            MediumTopAppBarExample(corutin,navBarState)
        }
        items(chatList.size){
            it->
                cardMessage(
                    IdImage = chatList[it].imageId,
                    title = chatList[it].title,
                    lastMsg = chatList[it].lastMsg)
        }
    }
}


@Composable
fun cardMessage(IdImage:Int,title: String, lastMsg: String){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            cardMessageImage(IdImage)
            cardMessageTitle(title,lastMsg)
        }
    }
}



@Composable
fun cardMessageImage(IdPhoto: Int){
    Box(modifier = Modifier.size(80.dp)){
        Image(
            modifier = Modifier
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
}

@Composable
fun cardMessageTitle(title: String,lastMsg: String){
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            fontSize = 24.sp,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = lastMsg,
            fontSize = 20.sp,
            color = Color.Gray

        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBarExample(corutin: CoroutineScope,navBarState : DrawerState) {

    TopAppBar(
        title= { headerProfile() },
        navigationIcon={ IconButton({corutin.launch { navBarState.open() }}) { Icon(Icons.Filled.Menu, contentDescription = "Меню")}},
        actions={
            IconButton({ }) {Icon(Icons.Filled.Search, contentDescription = "Поиск")}
        },
        colors=TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray,
            titleContentColor = Color.LightGray,
            navigationIconContentColor = Color.LightGray,
            actionIconContentColor = Color.LightGray),

    )
}



@Composable
fun NavBar(chatList:List<DataCardMsg>) {
    val NavigationItem: List<DataNavigationItem> = DataSource().loadItemsNavBar()
    val navBarState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val corutine = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = navBarState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painter = painterResource(id =R.drawable.ali),
                    contentDescription = "my",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    contentScale = ContentScale.Crop
                )
                NavigationItem.forEach {
                        it->
                    NavigationDrawerItem(
                        label = { Text(text = it.title) },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = it.imageVector,
                                contentDescription = it.title
                            )
                        },
                        onClick = {
                            corutine.launch {
                                navBarState.close()
                            }
                        })

                }

            }
        },
        content = {
            MyChats(chatList = DataSource().loadChats(), corutin = corutine, navBarState = navBarState)
        }
    )
}

@Preview
@Composable
fun sf(){
//    cardMessage(R.drawable.ali,"lili","sdqwdqdw")
//    MyChats(chatList = DataSource().loadChats())
//    MediumTopAppBarExample()

}