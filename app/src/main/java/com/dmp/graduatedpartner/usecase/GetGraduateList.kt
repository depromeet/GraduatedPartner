package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.const.*
import com.dmp.graduatedpartner.repository.GraduateListRepository

class GetGraduateList(private val graduateListRepository: GraduateListRepository) {
    operator fun invoke() = graduateListRepository.get(GRADUATE_LIST_KEY)
}