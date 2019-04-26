package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.GradRequDataSource
import com.dmp.graduatedpartner.datasource.local.GradeDataSource
import com.dmp.graduatedpartner.model.GradRequ
import com.dmp.graduatedpartner.model.Grade

class GradRequRepository(private val gradRequDataSource: GradRequDataSource) {
    fun get(key: String) = gradRequDataSource.get(key)
    fun put(key: String, content: GradRequ) = gradRequDataSource.put(key, content)
}