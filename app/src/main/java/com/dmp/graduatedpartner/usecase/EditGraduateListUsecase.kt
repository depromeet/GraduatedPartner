package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.const.GRADUATE_LIST_KEY
import com.dmp.graduatedpartner.model.GraduateList
import com.dmp.graduatedpartner.repository.GraduateListRepository

class EditGraduateListUsecase(private val graduateListRepository: GraduateListRepository) {

    operator fun invoke(content: GraduateList) {
        graduateListRepository.put(GRADUATE_LIST_KEY, content)
    }
}
