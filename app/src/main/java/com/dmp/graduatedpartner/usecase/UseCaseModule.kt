package com.dmp.graduatedpartner.usecase

import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUser(get()) }
    factory { GetKey(get()) }
    factory { PutUser(get()) }
}