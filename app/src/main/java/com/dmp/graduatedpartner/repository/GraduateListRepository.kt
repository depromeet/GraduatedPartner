package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.GraduateListDataSource
import com.dmp.graduatedpartner.model.GraduateList

class GraduateListRepository(private val graduateListDataSource: GraduateListDataSource) {
    fun get(key: String) = graduateListDataSource.get(key)
    fun put(key: String, content: GraduateList) = graduateListDataSource.put(key, content)
}