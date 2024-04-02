package ru.sfedu.vibe.model

sealed class Destination(val route : String){
    object SelectPage : Destination("selectPage")
    object Entry: Destination("entry")
    object Registration : Destination("registration")
    object ChatList : Destination("chatList")
}