package com.sopian.challenge5.domain.usecase.register

import com.sopian.challenge5.data.UserRepository
import com.sopian.challenge5.data.source.local.entity.UserEntity

class RegisterUserUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity) {
        return userRepository.insertUser(userEntity)
    }
}