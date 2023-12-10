package com.esosaphilip.hulaba

import androidx.room.Room
import com.esosaphilip.hulaba.data.WordDao
import com.esosaphilip.hulaba.data.WordsDatabase
import com.esosaphilip.hulaba.repo.WordRepo
import com.esosaphilip.hulaba.ui.home.HomeViewModel
import com.esosaphilip.hulaba.ui.screens.WordEntryViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        provideDatabase(androidApplication() as WordApplication)
    }
    single {
        provideDao(get())
    }
    single {
        WordRepo(get())
    }
    viewModel {
        HomeViewModel(get())
    }

    viewModel {
        WordEntryViewModel(get())
    }
}

private fun provideDatabase(application: WordApplication): WordsDatabase {
    return Room.databaseBuilder(
        application,
        WordsDatabase::class.java,
        "database-name",
    ).fallbackToDestructiveMigration().build()
}

private fun provideDao(db: WordsDatabase): WordDao = db.getWordDao()
