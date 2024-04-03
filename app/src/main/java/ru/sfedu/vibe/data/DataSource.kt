package ru.sfedu.vibe.data


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.core.content.ContextCompat.getString
import androidx.core.content.res.TypedArrayUtils.getText


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

    fun loadsItemsFriend() : List<DataFriend>{
        val itemsFriend = listOf<DataFriend>(
            DataFriend(
                R.drawable.someone_else,
                "Dima",
                "Онлайн"
                ),
            DataFriend(
                R.drawable.ali,
                "Ali DOD",
                "Онлайн"
            ),
            DataFriend(
                R.drawable.ali,
                "Ali DOD",
                "Не в сети"
            ),
            DataFriend(
                R.drawable.ali,
                "Ali DOD",
                "Онлайн"
            )
        )
        return itemsFriend

    }
}