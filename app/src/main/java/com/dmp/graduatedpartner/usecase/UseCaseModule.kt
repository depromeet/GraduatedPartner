package com.dmp.graduatedpartner.usecase

import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUserUsecase(get()) }
    factory { GetGradeUsecase(get()) }
    factory { SignInUsecase(get(), get(), get()) }
    factory { EditGradeUsecase(get()) }
    factory { GetUserGradeUsecase(get()) }
    factory { GetGraduateListUsecase(get()) }
}