package com.esosaphilip.hulaba

import android.app.Application
import androidx.annotation.ReturnThis
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class WordApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@WordApplication)
            modules(appModule)
        }

    }


}