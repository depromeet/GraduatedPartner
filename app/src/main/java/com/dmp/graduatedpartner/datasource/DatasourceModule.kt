package com.dmp.graduatedpartner.datasource

import com.dmp.graduatedpartner.datasource.local.GradeDataSource
import com.dmp.graduatedpartner.datasource.local.GraduateDataSource
import com.dmp.graduatedpartner.datasource.local.UserDataSource
import com.dmp.graduatedpartner.datasource.local.UserGradeDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { GradeDataSource() }
    single { GraduateDataSource() }
    single { UserDataSource() }
    single { UserGradeDataSource()}
}