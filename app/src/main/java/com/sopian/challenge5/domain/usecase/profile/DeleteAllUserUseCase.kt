package com.sopian.challenge5.domain.usecase.profile

import com.sopian.challenge5.data.UserRepository

class DeleteAllUserUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() {
        return userRepository.deleteAllUser()
    }
}