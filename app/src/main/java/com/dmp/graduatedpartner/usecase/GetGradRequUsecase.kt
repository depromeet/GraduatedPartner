package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.repository.GradRequRepository
import com.dmp.graduatedpartner.repository.GradeRepository
import com.dmp.graduatedpartner.repository.UserRepository

class GetGradRequUsecase(private val gradRequRepository: GradRequRepository) {
    operator fun invoke(key: String) = gradRequRepository.get(key)
}