package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.repository.UserRepository

class GetUser(private val userRepository: UserRepository) {
    operator fun invoke(key: String) = userRepository.get(key)
}