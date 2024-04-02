package ru.sfedu.vibe.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.rememberTopAppBarState
import ru.sfedu.vibe.R

class DataSource {
    fun loadChats(): List<DataCardMsg>{
        val nature = listOf<DataCardMsg>(
            DataCardMsg(R.drawable.ali,"Ali","hi bob" ),
            DataCardMsg(R.drawable.ali,"Ali","hi bob" ),
            DataCardMsg(R.drawable.ali,"Ali","hi bob" ),
            DataCardMsg(R.drawable.ali,"Ali","hi bob" ),
            DataCardMsg(R.drawable.ali,"Ali","hi bob" ),
            DataCardMsg(R.drawable.ali,"Ali","hi bob" ),
            DataCardMsg(R.drawable.ali,"Ali","hi bob" ),
            )
        return nature;
    }

    fun loadItemsNavBar(): List<DataNavigationItem>{
        val itemsNav = listOf<DataNavigationItem>(
            DataNavigationItem(
                Icons.Default.AccountCircle,
                "Контакты"
            ),
            DataNavigationItem(
                Icons.Default.ExitToApp,
                "Выход"
            ),
            DataNavigationItem(
                Icons.Default.Settings,
                "Настройки"
            )
        )
        return itemsNav
    }
}