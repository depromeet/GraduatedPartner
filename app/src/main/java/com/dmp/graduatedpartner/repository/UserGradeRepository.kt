package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.UserGradeDataSource
import com.dmp.graduatedpartner.model.UserGrade

class UserGradeRepository(private val userGradeDataSource: UserGradeDataSource) {
    fun get(key: String) = userGradeDataSource.get(key)
    fun put(key: String, content: UserGrade) = userGradeDataSource.put(key, content)
}