package com.esosaphilip.hulaba.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.esosaphilip.hulaba.data.Word
import com.esosaphilip.hulaba.repo.WordRepo

class WordEntryViewModel(private val wordRepo: WordRepo ): ViewModel() {
    var wordUiState by mutableStateOf(WordUiState())
        private set


    fun updateUiState(newWordUiState: WordUiState) {
   //     wordUiState = newWordUiState.copy( actionEnabled = newWordUiState.isValid())
   }


    private fun WordUiState.isValid(): Boolean {
        return word.isNotBlank() && wordDefinition.isNotBlank() && example.isNotBlank()
    }

    private fun WordUiState.toWord(): Word = Word(
        id = id,
        word = word,
        wordDefinition = wordDefinition,
        example = example,
    )

   suspend fun saveWord(){
       if(wordUiState.isValid()){
           wordRepo.insertWord(wordUiState.toWord())
       }
    }





}