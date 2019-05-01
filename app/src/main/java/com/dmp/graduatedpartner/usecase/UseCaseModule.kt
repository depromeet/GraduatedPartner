package com.dmp.graduatedpartner.usecase

import org.koin.dsl.module

val useCaseModule = module {
    factory { EditGrade(get()) }
    factory { GetUser(get()) }
    factory { GetGrade(get()) }
    factory { SignIn(get(), get(), get()) }
    factory { GetUserGrade(get()) }
    factory { GetGraduateList(get()) }
}