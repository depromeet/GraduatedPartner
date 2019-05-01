package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.CourseDataSource
import com.dmp.graduatedpartner.model.Course

class UserGradeRepository(private val courseDataSource: CourseDataSource) {
    fun get(key: String) = courseDataSource.get(key)
    fun put(key: String, content: Course) = courseDataSource.put(key, content)
}