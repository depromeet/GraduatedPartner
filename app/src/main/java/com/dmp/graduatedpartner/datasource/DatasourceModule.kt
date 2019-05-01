package com.dmp.graduatedpartner.datasource

import com.dmp.graduatedpartner.datasource.local.*
import org.koin.dsl.module

val dataSourceModule = module {
    single { GradeDataSource() }
    single { UserDataSource() }
    single { CourseListDataSource() }
    single { GraduateListDataSource() }
}