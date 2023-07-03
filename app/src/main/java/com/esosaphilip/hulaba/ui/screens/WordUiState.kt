package com.esosaphilip.hulaba.ui.screens

import com.esosaphilip.hulaba.data.Word

data class WordUiState(
    val id: Int = 0,
    val word: String = "",
    val wordDefinition: String = "",
    val example: String = ""
) {


    fun WordUiState.toWord(): WordUiState = WordUiState(
        id = id,
        word = word,
        wordDefinition = wordDefinition,
        example = example,
    )

    fun Word.toWordUiState(actionEnabled: Boolean = false): WordUiState = WordUiState(
        id = id,
        word = word,
        wordDefinition = wordDefinition,
        example = example,
    )


    fun WordUiState.isValid(): Boolean {
        return word.isNotBlank() && wordDefinition.isNotBlank() && example.isNotBlank()
    }




}