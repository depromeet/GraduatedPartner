package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.GradeDataSource
import com.dmp.graduatedpartner.model.Grade

class GradeRepository(private val gradeDataSource: GradeDataSource) {
    fun get(key: String) = gradeDataSource.get(key)
    fun put(key: String, content: Grade) = gradeDataSource.put(key, content)
}