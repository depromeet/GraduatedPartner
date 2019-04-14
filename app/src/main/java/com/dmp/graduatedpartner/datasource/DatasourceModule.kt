package com.dmp.graduatedpartner.datasource

import com.dmp.graduatedpartner.datasource.local.UserDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { UserDataSource() }
}