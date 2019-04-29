package com.dmp.graduatedpartner.usecase

import org.koin.dsl.module

val useCaseModule = module {
    factory { EditGradeUsecase(get()) }
    factory { EditGraduateListUsecase(get()) }
    factory { GetUserUsecase(get()) }
    factory { GetGradeUsecase(get()) }
    factory { SignIn(get(), get(), get()) }
    factory { GetUserGradeUsecase(get()) }
}