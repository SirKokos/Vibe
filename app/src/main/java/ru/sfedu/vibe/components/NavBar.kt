package ru.sfedu.vibe.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sfedu.vibe.R
import ru.sfedu.vibe.data.DataNavigationItem
import ru.sfedu.vibe.data.DataSource

//@Preview
//@Composable
//fun NavBar(){
//    val NavigationItem: List<DataNavigationItem> = DataSource().loadItemsNavBar()
//    val navBarState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val corutine = rememberCoroutineScope()
//    ModalNavigationDrawer(
//        drawerState = navBarState,
//        drawerContent = {
//            ModalDrawerSheet {
//                Image(
//                    painter = painterResource(id =R.drawable.ali),
//                    contentDescription = "my",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(120.dp),
//                    contentScale = ContentScale.Crop
//                )
//                NavigationItem.forEach {
//                    it->
//                    NavigationDrawerItem(
//                        label = { Text(text = it.title) },
//                        selected = false,
//                        icon = {
//                            Icon(
//                                imageVector = it.imageVector,
//                                contentDescription = it.title
//                            )
//                        },
//                        onClick = {
//
//                    })
//
//                }
//
//            }
//        },
//        content = {
//            MyChats(chatList = DataSource().loadChats())
//        }
//    )
//}