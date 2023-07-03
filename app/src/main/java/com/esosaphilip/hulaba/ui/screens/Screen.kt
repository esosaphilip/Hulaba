package com.esosaphilip.hulaba.ui.screens

sealed class Screen(val route: String){
    object HomeScreen: Screen(route = "Home_Screen")
    object WordScreen: Screen(route = "Word_Screen")
    object EnterWordScreen: Screen(route = "Enter_Word")
}
