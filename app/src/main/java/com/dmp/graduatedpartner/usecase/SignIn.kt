package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.const.*
import com.dmp.graduatedpartner.model.Grade
import com.dmp.graduatedpartner.model.Graduate
import com.dmp.graduatedpartner.model.User
import com.dmp.graduatedpartner.repository.GradeRepository
import com.dmp.graduatedpartner.repository.GraduateListRepository
import com.dmp.graduatedpartner.repository.UserRepository

class SignIn(
    private val userRepository: UserRepository,
    private val gradeRepository: GradeRepository,
    private val graduateListRepository: GraduateListRepository
) {
    operator fun invoke(
        userName: String,
        currentSemester: Int,
        totalSemester: Int,
        currentGrade: Int,
        totalGrade: Int,
        graduateList: List<Graduate>
    ) {
        userRepository.put(USER_KEY, User(userName, currentSemester, totalSemester))
        gradeRepository.put(TOTAL_GRADE_KEY, Grade(currentGrade, totalGrade))
        gradeRepository.put(MAJOR_GRADE_KEY, Grade(0, 0))
        gradeRepository.put(CULTURE_GRADE_KEY, Grade(0, 0))
        gradeRepository.put(ETC_GRADE_KEY, Grade(currentGrade, totalGrade))
        graduateListRepository.put(GRADUATE_LIST_KEY, graduateList)
    }
}