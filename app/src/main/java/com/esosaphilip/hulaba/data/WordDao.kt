package com.esosaphilip.hulaba.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)

    @Delete
    suspend fun delete(word: Word)

    @Update
    suspend fun update(word: Word)

    @Query("SELECT * from words ORDER BY word Asc"  )
    fun getAllWords(): Flow<List<Word>>

    @Query("SELECT * from words WHERE id = :id")
    fun getWord(id: Int): Flow<Word>

}