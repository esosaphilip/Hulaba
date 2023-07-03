package com.esosaphilip.hulaba.repo

import com.esosaphilip.hulaba.data.Word
import com.esosaphilip.hulaba.data.WordDao
import kotlinx.coroutines.flow.Flow


class WordRepo(private val dao: WordDao){
    fun getAllWordsDetails(): Flow<List<Word>> {
        return dao.getAllWords()
    }
fun getWordDetails(id: Int): Flow<Word> {
    return dao.getWord(id)
}
    suspend fun updateWord(word: Word) = dao.update(word)

    suspend fun insertWord(word: Word) {
        dao.insert(word)
    }

    suspend fun deleteWord(word: Word) = dao.delete(word)


}