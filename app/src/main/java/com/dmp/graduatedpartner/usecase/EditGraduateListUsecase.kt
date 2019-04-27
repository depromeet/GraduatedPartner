package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.const.GRADUATE_LIST_KEY
import com.dmp.graduatedpartner.model.GradRequ
import com.dmp.graduatedpartner.model.GraduateList
import com.dmp.graduatedpartner.model.UserGrade
import com.dmp.graduatedpartner.repository.GraduateListRepository
import com.dmp.graduatedpartner.repository.UserGradeRepository

class EditGraduateListUsecase(private val graduateListRepository: GraduateListRepository) {

    operator fun invoke(content: GraduateList) {
        graduateListRepository.put(GRADUATE_LIST_KEY, content)
    }
}
