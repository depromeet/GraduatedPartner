package com.dmp.graduatedpartner.usecase

import org.koin.dsl.module

val useCaseModule = module {
    factory { UpdateGrade(get()) }
    factory { GetUser(get()) }
    factory { GetGrade(get()) }
    factory { SignIn(get(), get(), get()) }
    factory { GetGraduateList(get()) }
}