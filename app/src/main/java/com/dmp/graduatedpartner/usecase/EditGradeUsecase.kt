package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.const.CULTURE_GRADE_KEY
import com.dmp.graduatedpartner.const.ETC_GRADE_KEY
import com.dmp.graduatedpartner.const.MAJOR_GRADE_KEY
import com.dmp.graduatedpartner.const.TOTAL_GRADE_KEY
import com.dmp.graduatedpartner.model.Grade
import com.dmp.graduatedpartner.repository.GradeRepository

class EditGradeUsecase(private val gradeRepository: GradeRepository) {
    operator fun invoke(
        majorCurrent: Int, majorTotal: Int,
        cultureCurrent: Int, cultureTotal: Int,
        etcCurrent: Int, etcTotal: Int
    ) {
        gradeRepository.put(MAJOR_GRADE_KEY, Grade(majorCurrent, majorTotal))
        gradeRepository.put(CULTURE_GRADE_KEY, Grade(cultureCurrent, cultureTotal))
        gradeRepository.put(ETC_GRADE_KEY, Grade(etcCurrent, etcTotal))
        gradeRepository.put(
            TOTAL_GRADE_KEY,
            Grade(majorCurrent + cultureCurrent + etcCurrent, majorTotal + cultureTotal + etcTotal)
        )
    }
}