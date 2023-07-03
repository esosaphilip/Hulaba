package com.esosaphilip.hulaba.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Word::class],version = 1, exportSchema = false)
abstract class WordsDatabase: RoomDatabase(){

    abstract fun getWordDao(): WordDao
}