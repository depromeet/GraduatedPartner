package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.model.UserGrade
import com.dmp.graduatedpartner.repository.UserGradeRepository

class EditUserGradeUsecase(private val userGradeRepository: UserGradeRepository) {

    operator fun invoke(subjectType: Int, content: String, grade: Int, score: Double) {
        userGradeRepository.put("TYPE", UserGrade(subjectType,content,grade,score))
    }

}
