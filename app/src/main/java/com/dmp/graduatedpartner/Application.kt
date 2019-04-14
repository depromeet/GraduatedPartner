package com.dmp.graduatedpartner

import android.app.Application
import com.dmp.graduatedpartner.datasource.dataSourceModule
import com.dmp.graduatedpartner.presentation.viewModelModule
import com.dmp.graduatedpartner.repository.repositoryModule
import com.dmp.graduatedpartner.usecase.usecaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(viewModelModule, usecaseModule, repositoryModule, dataSourceModule))
        }
    }
}