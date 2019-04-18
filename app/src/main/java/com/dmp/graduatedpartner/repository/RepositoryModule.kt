package com.dmp.graduatedpartner.repository

import org.koin.dsl.module

val repositoryModule = module {
    single { UserRepository(get()) }
    single { KeyRepository(get()) }
}