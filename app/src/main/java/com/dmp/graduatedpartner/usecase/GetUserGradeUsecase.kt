package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.repository.UserGradeRepository

class GetUserGradeUsecase(private val userGradeRepository: UserGradeRepository) {
    operator fun invoke(key: String) = userGradeRepository.get(key)
}
