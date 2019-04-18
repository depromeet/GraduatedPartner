package com.dmp.graduatedpartner.datasource

import com.dmp.graduatedpartner.datasource.local.GradeDataSource
import com.dmp.graduatedpartner.datasource.local.GraduateDataSource
import com.dmp.graduatedpartner.datasource.local.KeyDataSource
import com.dmp.graduatedpartner.datasource.local.UserDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { GradeDataSource() }
    single { GraduateDataSource() }
    single { KeyDataSource() }
    single { UserDataSource() }
}