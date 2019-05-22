package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.repository.GraduateListRepository

class GetGraduateListUsecase(private val graduateListRepository: GraduateListRepository) {
    operator fun invoke(key: String) = graduateListRepository.get(key)
}