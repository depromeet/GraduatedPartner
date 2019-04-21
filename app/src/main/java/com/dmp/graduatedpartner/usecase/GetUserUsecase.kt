package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.repository.UserRepository

class GetUserUsecase(private val userRepository: UserRepository) {
    operator fun invoke(key: String) = userRepository.get(key)
}