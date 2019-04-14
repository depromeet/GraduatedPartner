package com.dmp.graduatedpartner.usecase

import org.koin.dsl.module

val usecaseModule = module {
    factory { GetSignIn(get()) }
}