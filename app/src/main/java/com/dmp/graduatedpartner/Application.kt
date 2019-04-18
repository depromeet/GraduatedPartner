package com.dmp.graduatedpartner

import android.app.Application
import android.content.Context
import com.dmp.graduatedpartner.datasource.dataSourceModule
import com.dmp.graduatedpartner.presentation.viewModelModule
import com.dmp.graduatedpartner.repository.repositoryModule
import com.dmp.graduatedpartner.usecase.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@Application)
            modules(listOf(viewModelModule, useCaseModule, repositoryModule, dataSourceModule))
        }
        appContext = this
    }

    companion object {
        var appContext: Context? = null
    }
}