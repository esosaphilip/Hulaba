package com.esosaphilip.hulaba.data // ktlint-disable filename

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val word: String,
    val wordDefinition: String,
    val example: String,
)
