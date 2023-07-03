package com.esosaphilip.hulaba.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esosaphilip.hulaba.R
import com.esosaphilip.hulaba.ui.navigation.NavigationDestination
import com.esosaphilip.hulaba.ui.word.ui.theme.HulabaTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.util.Currency
import java.util.Locale

object WordEntryDestination : NavigationDestination {
    override val route = Screen.EnterWordScreen.route
    override var titleRes = R.string.enterWord
}
@Composable
fun EnterWordScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean = true,
   viewModel: WordEntryViewModel = koinViewModel()
){

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(WordEntryDestination.titleRes),
                canNavigateBack = canNavigateBack,
                navigateUp = onNavigateUp
            )
        }
    ) { innerPadding ->
        WordEntryBody(
            wordUiState = viewModel.wordUiState,
            onItemValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveWord()
                    navigateBack()
                }
            },
            modifier = modifier.padding(innerPadding)
        )
    }

}

@Composable
fun WordEntryBody(
    wordUiState: WordUiState,
    onItemValueChange: (WordUiState) -> Unit,
   onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        WordEntryInputForm(wordUiState = wordUiState, onValueChange = onItemValueChange)

    }



}

@Composable
fun WordEntryInputForm(
    wordUiState: WordUiState,
    modifier: Modifier = Modifier,
    onValueChange: (WordUiState) -> Unit = {},
    enabled: Boolean = true
){
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        OutlinedTextField(
            value = wordUiState.word,
            onValueChange = { onValueChange(wordUiState.copy(word = it)) },
            label = {  },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = wordUiState.wordDefinition,
            onValueChange = { onValueChange(wordUiState.copy(wordDefinition = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = {  },
            leadingIcon = { Text(Currency.getInstance(Locale.getDefault()).symbol) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = wordUiState.example,
            onValueChange = { onValueChange(wordUiState.copy(example = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = {  },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}





@Composable
@Preview(showBackground = true)
fun EnterPreview(){
    HulabaTheme {
        WordEntryBody(
            wordUiState = WordUiState(
                word = "Application",
                wordDefinition = "Application is open source",
                example = "i want this App to Work"
            ),
            onItemValueChange = {},
           onSaveClick = {}
        )
    }
}