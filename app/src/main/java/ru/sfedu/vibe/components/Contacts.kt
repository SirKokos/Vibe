package ru.sfedu.vibe.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import ru.sfedu.vibe.R
import ru.sfedu.vibe.data.DataFriend
import ru.sfedu.vibe.data.DataNavigationItem
import ru.sfedu.vibe.data.DataSource
import ru.sfedu.vibe.model.Destination


@Composable
fun Contact( friendList:List<DataFriend>,navHostController : NavHostController){
    val NavigationItem: List<DataNavigationItem> = DataSource().loadItemsNavBar()
    val navBarState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val corutine = rememberCoroutineScope()
    val selectedItem = remember {
        mutableStateOf(NavigationItem[0])
    }
    ModalNavigationDrawer(
        drawerState = navBarState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painter = painterResource(id = R.drawable.ali),
                    contentDescription = "my",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(CircleShape)
                        .height(120.dp),
                    contentScale = ContentScale.Crop
                )

                NavigationItem.forEach {
                        it->
                    NavigationDrawerItem(
                        label = { Text(text = it.title) },
                        selected =false,
                        icon = {
                            Icon(
                                imageVector = it.imageVector,
                                contentDescription = it.title
                            )
                        },
                        onClick = {
                            corutine.launch  {
                                selectedItem.value = it
                                if (selectedItem.value.title == "Настройки"){
                                    navHostController.navigate(Destination.MyProfile.route)
                                }else if(selectedItem.value.title == "Контакты"){
                                    navHostController.navigate(Destination.ContactList.route)
                                }
//                                navBarState.close()

                            }
                        })

                }

            }
        },
        content = {
            MyFriends(friendList,corutine,navBarState)
        }
    )


}


@Composable
fun MyFriends(
    friendList:List<DataFriend>,
    corutine: CoroutineScope,
    navBarState : DrawerState,
    modifier: Modifier = Modifier,
){
    LazyColumn( modifier = Modifier){
        item (){
            MediumTopAppBarExample(corutine,navBarState)
        }
        items(friendList.size){
                it->
            cardFriend(
                IdImage = friendList[it].imageId,
                title = friendList[it].title,
                lastMsg = friendList[it].status,
                )
        }
    }
}

@Composable
fun cardFriend(IdImage:Int, title: String, lastMsg: String){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        border = BorderStroke(0.5.dp, Color.LightGray),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            cardFriendImage(IdImage)
            cardFriendTitle(title,lastMsg)
        }
    }
}


@Composable
fun cardFriendImage(IdPhoto: Int){
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
fun cardFriendTitle(title: String,status: String){
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            fontSize = 20.sp,
        )
        checkOnline(status)
    }
}

@Composable
fun checkOnline(status: String) {
    if (status == "Онлайн"){
        return Text(
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = status,
            fontSize = 18.sp,
            color = Color(0xFF78FF5F),
        )
    }
    return   return Text(
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        text = status,
        fontSize = 18.sp,
        color = Color.Gray,
    )
}


@Preview
@Composable
fun sf3(){
//    val navBarState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val corutine = rememberCoroutineScope()
//    cardMessage(R.drawable.ali,"lili","sdqwdqdw")
//    MyChats(chatList = DataSource().loadChats(),  )
//    MediumTopAppBarExample()
//    MyFriends(DataSource().loadsItemsFriend(),corutine,navBarState)

}