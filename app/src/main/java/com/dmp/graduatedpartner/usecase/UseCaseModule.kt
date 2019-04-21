package com.dmp.graduatedpartner.usecase

import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUser(get()) }
    factory { PutUser(get()) }
}