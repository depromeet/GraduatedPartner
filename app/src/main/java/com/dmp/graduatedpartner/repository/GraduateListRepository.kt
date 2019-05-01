package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.GraduateListDataSource
import com.dmp.graduatedpartner.model.Graduate

class GraduateListRepository(private val graduateListDataSource: GraduateListDataSource) {
    fun get(key: String) = graduateListDataSource.get(key)
    fun put(key: String, content: List<Graduate>) = graduateListDataSource.put(key, content)
}