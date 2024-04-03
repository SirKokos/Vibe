package ru.sfedu.vibe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.sfedu.vibe.components.Contact
import ru.sfedu.vibe.components.MyChats
import ru.sfedu.vibe.components.MyProfile
import ru.sfedu.vibe.components.entry
import ru.sfedu.vibe.components.registartion
import ru.sfedu.vibe.components.selectPage
import ru.sfedu.vibe.data.DataSource
import ru.sfedu.vibe.model.Destination
import ru.sfedu.vibe.ui.theme.VibeTheme

class RegistartionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            VibeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navigate(navController)
            }
        }
    }
}


@Composable
fun navigate(navController : NavHostController){
    NavHost(navController = navController, startDestination = "selectPage") {
        composable(Destination.SelectPage.route) { selectPage(navController) }
        composable(Destination.Registration.route){ registartion(navController) }
        composable(Destination.Entry.route){ entry(navController) }
        composable(Destination.ChatList.route){ MyChats(DataSource().loadChats(),navController) }
        composable(Destination.MyProfile.route){ MyProfile() }
        composable(Destination.ContactList.route){ Contact( DataSource().loadsItemsFriend() ,navController)}
    }
}

}