package com.sopian.challenge5.domain.usecase.profile

import com.sopian.challenge5.data.UserRepository
import com.sopian.challenge5.data.source.local.entity.UserEntity
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity) {
        return userRepository.updateUser(userEntity)
    }
}