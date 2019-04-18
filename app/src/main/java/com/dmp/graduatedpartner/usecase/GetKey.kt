package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.repository.KeyRepository

class GetKey(private val keyRepository: KeyRepository) {
    operator fun invoke(key: String) = keyRepository.get(key)
}