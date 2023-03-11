package com.esosaphilip.hulaba.ui.word

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.esosaphilip.hulaba.ui.word.ui.theme.HulabaTheme


@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    HulabaTheme {
        Greeting2("Android")
    }
}