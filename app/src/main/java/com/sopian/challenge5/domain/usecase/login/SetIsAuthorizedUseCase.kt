package com.sopian.challenge5.domain.usecase.login

import com.sopian.challenge5.data.UserRepository
import com.sopian.challenge5.data.source.local.entity.UserEntity

class SetIsAuthorizedUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity, isAuthorizedState: Boolean) {
        return userRepository.setIsAuthorized(userEntity, isAuthorizedState)
    }
}