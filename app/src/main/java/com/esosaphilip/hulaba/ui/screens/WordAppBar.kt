package com.esosaphilip.hulaba.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.w3c.dom.Text

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    canNavigateBack: Boolean,
    navigateUp :() -> Unit = {}
    ){


    if (canNavigateBack) {
        androidx.compose.material.TopAppBar(
            title = { Text(title) },
            modifier = modifier,
            navigationIcon = {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        )
    } else {
        androidx.compose.material.TopAppBar(title = { Text(title) }, modifier = modifier)
    }
}