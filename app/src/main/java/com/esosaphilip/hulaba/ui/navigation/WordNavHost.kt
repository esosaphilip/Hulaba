package com.esosaphilip.hulaba.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esosaphilip.hulaba.ui.home.HomeScreen
import com.esosaphilip.hulaba.ui.screens.EnterWordScreen
import com.esosaphilip.hulaba.ui.screens.Screen
import com.esosaphilip.hulaba.ui.screens.WordList


@Composable
fun WordNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.HomeScreen.route

    ){

    NavHost(navController = navController,
        startDestination =  startDestination ){
        composable(
            route = Screen.HomeScreen.route
        )
        {
           HomeScreen(
               navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
               navigateToItemUpdate = {
                   navController.navigate("${ItemDetailsDestination.route}/${it}")
               },

           )
        }
        composable(
            route = Screen.WordScreen.route
        )
        {
           WordList()
        }
        composable(
            route = Screen.EnterWordScreen.route
        )
        {
           EnterWordScreen(
               navigateBack = { navController.popBackStack() },
               onNavigateUp = { navController.navigateUp() },
           )

        }

    }

}