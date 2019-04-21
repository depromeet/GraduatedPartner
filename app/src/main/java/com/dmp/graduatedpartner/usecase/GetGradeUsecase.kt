package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.repository.GradeRepository
import com.dmp.graduatedpartner.repository.UserRepository

class GetGradeUsecase(private val gradeRepository: GradeRepository) {
    operator fun invoke(key: String) = gradeRepository.get(key)
}