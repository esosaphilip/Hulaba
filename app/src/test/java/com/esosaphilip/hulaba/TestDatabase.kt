package com.esosaphilip.hulaba

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.esosaphilip.hulaba.data.WordDao
import com.esosaphilip.hulaba.data.WordsDatabase
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var wordDao: WordDao
    private lateinit var db: WordsDatabase

    @Before
    fun createDb() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, WordsDatabase::class.java).build()
        wordDao = db.getWordDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeWordAndReadInList() = runBlocking {
        val word: String = "Emfang"
       // wordDao.insert(word)
        val byName = wordDao.getAllWords()
        assertThat(byName, equalTo(word))
    }






}

