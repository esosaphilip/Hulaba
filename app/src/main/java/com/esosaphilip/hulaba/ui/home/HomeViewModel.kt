package com.esosaphilip.hulaba.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esosaphilip.hulaba.data.Word
import com.esosaphilip.hulaba.repo.WordRepo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(repo: WordRepo): ViewModel() {

val homeUiState: StateFlow<HomeUiState> =
    repo.getAllWordsDetails().map { HomeUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

}

data class HomeUiState(val wordList: List<Word> = listOf())