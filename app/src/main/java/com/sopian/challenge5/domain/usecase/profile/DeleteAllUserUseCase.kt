package com.sopian.challenge5.domain.usecase.profile

import com.sopian.challenge5.data.UserRepository
import javax.inject.Inject

class DeleteAllUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() {
        return userRepository.deleteAllUser()
    }
}