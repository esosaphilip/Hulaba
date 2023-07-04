package com.esosaphilip.hulaba.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esosaphilip.hulaba.R
import com.esosaphilip.hulaba.WordTopAppBar
import com.esosaphilip.hulaba.data.Word
import com.esosaphilip.hulaba.ui.navigation.NavigationDestination
import com.esosaphilip.hulaba.ui.screens.Screen

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    navigateToItemUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    val homeUiState by viewModel.homeUiState.collectAsState()
    Scaffold(
        topBar = {
            WordTopAppBar(
                title = stringResource(HomeDestination.titleRes),
                canNavigateBack = false
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                modifier = Modifier.navigationBarsPadding()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.word_entry_title),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        },
    ) { innerPadding ->
        HomeBody(
            wordList = homeUiState.wordList,
            onItemClick = navigateToItemUpdate,
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun HomeBody(
    wordList: List<Word>,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
       // InventoryListHeader()
        Divider()
        if (wordList.isEmpty()) {
            Text(
                text = stringResource(R.string.no_word_description),
                style = MaterialTheme.typography.subtitle2
            )
        } else {
            WordInventoryList(wordList = wordList, onItemClick = { onItemClick(it.id) })
        }
    }
}
@Composable
private fun WordInventoryList(
    words: List<Word>,
    onItemClick: (Word) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(words = words, key = { it.id }) {word ->
            WordDictionary(word = word, onItemClick = onItemClick)
            Divider()
        }
    }
}

@Composable
private fun WordDictionary(
    word: Word,
    onItemClick: (Word) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .clickable { onItemClick(word) }
        .padding(vertical = 16.dp)
    ) {
        Text(
            text = word.word,
            modifier = Modifier.weight(1.5f),
            fontWeight = FontWeight.Bold
        )

    }
}



@Composable
@Preview(showBackground = true)
fun HomePreview(){
    Screen.HomeScreen
}