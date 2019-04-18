package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.KeyDataSource
import com.dmp.graduatedpartner.model.Key

class KeyRepository(private val keyDataSource: KeyDataSource) {
    fun get(key: String) = keyDataSource.get(key)
    fun put(key: String, content: Key) = keyDataSource.put(key, content)
}