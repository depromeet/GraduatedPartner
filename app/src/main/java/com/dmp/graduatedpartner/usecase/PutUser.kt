package com.dmp.graduatedpartner.usecase

import com.dmp.graduatedpartner.model.User
import com.dmp.graduatedpartner.repository.UserRepository

class PutUser(private val userRepository: UserRepository) {
    operator fun invoke(key: String, content: User) = userRepository.put(key, content)
}