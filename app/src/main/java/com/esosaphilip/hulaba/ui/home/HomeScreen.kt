package com.esosaphilip.hulaba.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(
modifier: Modifier = Modifier,
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)
    ) {

    }



}


@Composable
@Preview(showBackground = true)
fun HomePreview(){
    HomeScreen()
}