package com.dmp.graduatedpartner

import android.app.Application
import com.dmp.graduatedpartner.presentation.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(viewModelModule))
        }
    }
}